#include "sys.h"
#include "delay.h"
#include "usart.h"
#include "led.h"
#include "timer.h"
#include "oled.h"
#include "beep.h"
#include "mpu6050.h"
#include "inv_mpu.h"
#include "MLX90614.h"
#include "sv17f.h"
#include "ATGM336H.h"
#include "key.h"
#include "menu.h"
#include "exti.h"
#include "OLED.h"
#include "adc.h"
#include "max30102.h" 
#include "maxiic.h"
#include "lsens.h"


#include "onenet.h"
#include "esp8266.h"


u8 Heart=130;       //������ֵ
u8 Bloodox=113;       //Ѫ����ֵ
float TempY=34.5;       //������ֵ
int Bloodpr=27;       //Ѫѹ��ֵ

u8 FlagCA=0;		//APPȡ���������ر�־
u8 oledshow=0;     //�����쳣ʱOLED������ʾ
u8 HR,SPO2;
short DSB;
float Temp;
u8 Flag=0,Flag1=0,Flag2=0,Flag3;
short aacx,aacy,aacz;		//���ٶȴ�����ԭʼ����
double a,svm;
float pitch,roll,yaw; 		//ŷ����
char PUT_BUF[256];   //���������Ϣ�Ļ�����
const char *Sub_topics[] = {"/ifmhmtZTe0e/STM32/user/subscribe"};    //������Ϣ��Topic������������
const char Pub_topics[] = {"/ifmhmtZTe0e/STM32/user/release"};		//������Ϣ��Topuc������������

int ad1,ad2,v1,v2,p=0,blood=0;

double longitude=11130.31707;
double latitude=2425.02898;
//unsigned char *latitude;
//unsigned char *longitude;

int nor1=0;  //���� 1.��������
int nor2=0;  //���� 2.���ʱ���
int nor3=0;  //���� 3.���±���  
int nor4=0;  //���� 4.Ѫѹ���� 
int nor5=0;  //���� 5.�ֶ�����
u8 key = 0;//������

void ADCX(){
	
		ad1=Get_Adc_Average(ADC_Channel_0,50); //50ȡƽ��ֵ
		v1=ad1/1.242;	//�õ�1ͨ����ѹֵ  �Ŵ���100�� 
		p=0.48471*v1 + 4.4168; // p= 48.471x + 4.4168  �õ���ѹֵ
	  if(p<5) p=0;	//��ʼֵ���� 		
		blood=p/5;
}

void Hardware_Init(void)
{ 
	NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);//�����ж����ȼ�����Ϊ��2��2λ��ռ���ȼ���2λ��Ӧ���ȼ� 
	delay_init();	        //��ʱ������ʼ��	
	LED_Init();	            //LED�Ƴ�ʼ��
	 SV17F_Init();
	 BEEP_Init();			//��������ʼ��
	 MPU_Init();					//��ʼ��MPU6050
	mpu_dmp_init();
	 SMBus_Init();
	EXTIX_Init();
	Adc_Init();		  		//ADC��ʼ��	 
	max30102_init();
	MAX30102_data_set();	
	OLED_Init();
	OLED_Display_On();
	OLED_Clear();
		KEY_Init();
	 uart_init(9600);		    //����1����ӡ��Ϣ��
	Usart2_Init(115200);		//����2������ESP8266��
//	
	
	 TIM3_Int_Init(9999,7199);		//��ʱ��3��ʼ��
//	 TIM4_Int_Init(4999,7199);		//��ʱ��4��ʼ��
	
	printf( "��ʼ�����\r\n");
	

}

 int main(void)
 {	

	 double sqrt( double  x);
	unsigned short timeCount = 0;	//���ͼ������
	unsigned char *dataPtr = NULL;    //������ձ���
 
		Hardware_Init();
	 
	 //��ʼ����WIFI
	ESP8266_Init();					//��ʼ��ESP8266	 	
	while(OneNet_DevLink())			//����MQTTЭ��
	delay_ms(500);	
	BEEP=1;
	delay_ms(250);                 //��������һ����ʾ����ɹ�
	BEEP=0;	
	OneNet_Subscribe(Sub_topics, 1);    //��ʼ������Ϣ������OK��ʾ���ĳɹ�
	 TIM2_Int_Init(4999,7199);		//��ʱ��2��ʼ����0.5��
	 //�������в���
	  IO0=0;
	delay_ms(2000);
	  IO0=1;
	
	while(1)
	{
	  	Menu_key_set();                            //OLED�˵�����ʾ
		  mpu_dmp_get_data(&pitch,&roll,&yaw);       //�õ���̬������ֵ
			MPU_Get_Accelerometer(&aacx,&aacy,&aacz);	//�õ����ٶȴ���������		
			a=aacx*aacx+aacy*aacy+aacz*aacz;
			svm=sqrt(a);
		 //�����ж��߼�		
			if(roll<-70 || roll>70 ||pitch<-70 || pitch>70)
			{
				if(svm>25000){				 
					oledshow=1;   //OLED��ʾ�����쳣����
           Flag=1;														
			}
       }
    //����������ȡ��		
				key=KEY_Scan(0);
				if(key==1){           
				  Flag=2;
					IO2=1;      //���������ر�
					nor1=0;   //�����ϴ���־  1.�쳣  0.����
					nor2=0;
		      nor3=0;
		      nor4=0;
					nor5=0;
					oledshow=2;
				}
		//�ֶ������ϱ�
      if(key==2){
				nor5=1;     //�ֶ������ϴ���־   1.�쳣 0.����
			  IO3=0;
			}else {
				IO3=1;
			}	
		 
	
	
	if(timeCount % 25 ==0)
	{	
    MAX30102_get(&HR,&SPO2);	
	  ADCX();	                 //��ȡѪѹ
		Temp=SMBus_ReadTemp();   //��ȡ����		
   	parseGpsBuffer();      //GPS���ݽ���
		printGpsBuffer();      //��ȡGPS����
	
		//��γ�ȶ�λ�ɹ���ֵ		
		latitude=atof(Save_Data.latitude);
		longitude=atof(Save_Data.longitude);	
					
		//���彡�������쳣ʱ����
		if(HR>=Heart || SPO2>Bloodox){
			 IO1=0;
			 nor2=1;     //���ʻ�Ѫ�������ϴ���־     1.�쳣  0.����
		}else if(Temp>TempY){
		  IO1=0;
		  nor3=1;    //���±����ϴ���־            1.�쳣  0.����
		}else if(blood>Bloodpr){
			IO1=0;
		  nor4=1;    //Ѫѹ�����ϴ���־            1.�쳣  0.����
		}else{
		 IO1=1;
//		 nor2=0;
//		 nor3=0;
//		 nor4=0;
		}		
		printf("�¶�: %.2f  ����:%3d  Ѫ��:%3d  Ѫѹ:%d ����:%f γ��:%f\n\r",Temp,HR,SPO2,blood,latitude,longitude);
			
	}
	if(++timeCount >= 50)									//���ͼ�������1.5���ϴ�һ��
		{		 
			printf("������Ϣ\r\n");
			
					sprintf(PUT_BUF,"{\"heart\":%3d,\"Bloodox\":%3d,\"temp\":%.1f,\"Bloodpr\":%d,\"longitude\":%f,\"latitude\":%f,\
		\"nor1\":%d,\"nor2\":%d,\"nor3\":%d,\"nor4\":%d,\"nor5\":%d}",HR,SPO2,Temp,blood,longitude,latitude,nor1,nor2,nor3,nor4,nor5);   //�����ݷ��͵�������
			OneNet_Publish(Pub_topics, PUT_BUF);		 //����ϴ�
			
			timeCount = 0;
			ESP8266_Clear();
			LED0=!LED0;
		}
		
		dataPtr = ESP8266_GetIPD(3);          //8266���շ���ֵ
		if(dataPtr != NULL)
			OneNet_RevPro(dataPtr);
		
		delay_ms(10);						//�ӳ�
	}
}
 


