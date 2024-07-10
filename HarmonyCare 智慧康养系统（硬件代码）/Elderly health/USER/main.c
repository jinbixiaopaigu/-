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


u8 Heart=130;       //心率阈值
u8 Bloodox=113;       //血氧阈值
float TempY=34.5;       //体温阈值
int Bloodpr=27;       //血压阈值

u8 FlagCA=0;		//APP取消报警返回标志
u8 oledshow=0;     //老人异常时OLED界面显示
u8 HR,SPO2;
short DSB;
float Temp;
u8 Flag=0,Flag1=0,Flag2=0,Flag3;
short aacx,aacy,aacz;		//加速度传感器原始数据
double a,svm;
float pitch,roll,yaw; 		//欧拉角
char PUT_BUF[256];   //定义接受消息的缓冲区
const char *Sub_topics[] = {"/ifmhmtZTe0e/STM32/user/subscribe"};    //订阅消息的Topic，可随意设置
const char Pub_topics[] = {"/ifmhmtZTe0e/STM32/user/release"};		//发布消息的Topuc，可随意设置

int ad1,ad2,v1,v2,p=0,blood=0;

double longitude=11130.31707;
double latitude=2425.02898;
//unsigned char *latitude;
//unsigned char *longitude;

int nor1=0;  //报警 1.跌倒报警
int nor2=0;  //报警 2.心率报警
int nor3=0;  //报警 3.体温报警  
int nor4=0;  //报警 4.血压报警 
int nor5=0;  //报警 5.手动报警
u8 key = 0;//按键数

void ADCX(){
	
		ad1=Get_Adc_Average(ADC_Channel_0,50); //50取平均值
		v1=ad1/1.242;	//得到1通道电压值  放大了100倍 
		p=0.48471*v1 + 4.4168; // p= 48.471x + 4.4168  得到气压值
	  if(p<5) p=0;	//初始值归零 		
		blood=p/5;
}

void Hardware_Init(void)
{ 
	NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);//设置中断优先级分组为组2：2位抢占优先级，2位响应优先级 
	delay_init();	        //延时函数初始化	
	LED_Init();	            //LED灯初始化
	 SV17F_Init();
	 BEEP_Init();			//蜂鸣器初始化
	 MPU_Init();					//初始化MPU6050
	mpu_dmp_init();
	 SMBus_Init();
	EXTIX_Init();
	Adc_Init();		  		//ADC初始化	 
	max30102_init();
	MAX30102_data_set();	
	OLED_Init();
	OLED_Display_On();
	OLED_Clear();
		KEY_Init();
	 uart_init(9600);		    //串口1，打印信息用
	Usart2_Init(115200);		//串口2，驱动ESP8266用
//	
	
	 TIM3_Int_Init(9999,7199);		//定时器3初始化
//	 TIM4_Int_Init(4999,7199);		//定时器4初始化
	
	printf( "初始化完成\r\n");
	

}

 int main(void)
 {	

	 double sqrt( double  x);
	unsigned short timeCount = 0;	//发送间隔变量
	unsigned char *dataPtr = NULL;    //定义接收变量
 
		Hardware_Init();
	 
	 //开始连接WIFI
	ESP8266_Init();					//初始化ESP8266	 	
	while(OneNet_DevLink())			//接入MQTT协议
	delay_ms(500);	
	BEEP=1;
	delay_ms(250);                 //蜂鸣器响一声表示接入成功
	BEEP=0;	
	OneNet_Subscribe(Sub_topics, 1);    //开始订阅消息，返回OK表示订阅成功
	 TIM2_Int_Init(4999,7199);		//定时器2初始化，0.5秒
	 //语音进行播报
	  IO0=0;
	delay_ms(2000);
	  IO0=1;
	
	while(1)
	{
	  	Menu_key_set();                            //OLED菜单栏显示
		  mpu_dmp_get_data(&pitch,&roll,&yaw);       //得到姿态传感器值
			MPU_Get_Accelerometer(&aacx,&aacy,&aacz);	//得到加速度传感器数据		
			a=aacx*aacx+aacy*aacy+aacz*aacz;
			svm=sqrt(a);
		 //跌倒判断逻辑		
			if(roll<-70 || roll>70 ||pitch<-70 || pitch>70)
			{
				if(svm>25000){				 
					oledshow=1;   //OLED显示老人异常界面
           Flag=1;														
			}
       }
    //按键报警和取消		
				key=KEY_Scan(0);
				if(key==1){           
				  Flag=2;
					IO2=1;      //语音播报关闭
					nor1=0;   //报警上传标志  1.异常  0.正常
					nor2=0;
		      nor3=0;
		      nor4=0;
					nor5=0;
					oledshow=2;
				}
		//手动报警上报
      if(key==2){
				nor5=1;     //手动报警上传标志   1.异常 0.正常
			  IO3=0;
			}else {
				IO3=1;
			}	
		 
	
	
	if(timeCount % 25 ==0)
	{	
    MAX30102_get(&HR,&SPO2);	
	  ADCX();	                 //获取血压
		Temp=SMBus_ReadTemp();   //获取体温		
   	parseGpsBuffer();      //GPS数据解析
		printGpsBuffer();      //获取GPS数据
	
		//经纬度定位成功赋值		
		latitude=atof(Save_Data.latitude);
		longitude=atof(Save_Data.longitude);	
					
		//身体健康数据异常时报警
		if(HR>=Heart || SPO2>Bloodox){
			 IO1=0;
			 nor2=1;     //心率或血氧报警上传标志     1.异常  0.正常
		}else if(Temp>TempY){
		  IO1=0;
		  nor3=1;    //体温报警上传标志            1.异常  0.正常
		}else if(blood>Bloodpr){
			IO1=0;
		  nor4=1;    //血压报警上传标志            1.异常  0.正常
		}else{
		 IO1=1;
//		 nor2=0;
//		 nor3=0;
//		 nor4=0;
		}		
		printf("温度: %.2f  心率:%3d  血氧:%3d  血压:%d 经度:%f 纬度:%f\n\r",Temp,HR,SPO2,blood,latitude,longitude);
			
	}
	if(++timeCount >= 50)									//发送间隔，大概1.5秒上传一次
		{		 
			printf("发布消息\r\n");
			
					sprintf(PUT_BUF,"{\"heart\":%3d,\"Bloodox\":%3d,\"temp\":%.1f,\"Bloodpr\":%d,\"longitude\":%f,\"latitude\":%f,\
		\"nor1\":%d,\"nor2\":%d,\"nor3\":%d,\"nor4\":%d,\"nor5\":%d}",HR,SPO2,Temp,blood,longitude,latitude,nor1,nor2,nor3,nor4,nor5);   //将数据发送到服务器
			OneNet_Publish(Pub_topics, PUT_BUF);		 //打包上传
			
			timeCount = 0;
			ESP8266_Clear();
			LED0=!LED0;
		}
		
		dataPtr = ESP8266_GetIPD(3);          //8266接收返回值
		if(dataPtr != NULL)
			OneNet_RevPro(dataPtr);
		
		delay_ms(10);						//延迟
	}
}
 


