#include "stm32f10x.h" // Device header
#include "KEY.h"
#include "DELAY.h"

u8 Key1= 0;
u8 Key2= 0;

void KEY_Init(void)

{
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA, ENABLE);

	GPIO_InitTypeDef GPIO_Initstructure;
	GPIO_Initstructure.GPIO_Mode = GPIO_Mode_IPU;
	GPIO_Initstructure.GPIO_Pin = GPIO_Pin_11 | GPIO_Pin_12 | GPIO_Pin_6| GPIO_Pin_7;
	GPIO_Init(GPIOA, &GPIO_Initstructure);
}

uint8_t KEY1_Get(void)
{
	if (GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_11) == 0)
	{
		delay_ms(20);
		while (GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_11) == 0)
			;
		delay_ms(20);
		Key1=1;
	}
	else
		Key1=0;

	return Key1;
}

uint8_t KEY2_Get(void)
{
	if (GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_12) == 0)
	{
		delay_ms(20);
		while (GPIO_ReadInputDataBit(GPIOA, GPIO_Pin_12) == 0)
			;
		delay_ms(20);
		Key2= 1;
	}
	else
		Key2=0;

	return Key2;
}

//����������
//���ذ���ֵ
//mode:0,��֧��������;1,֧��������;
//����ֵ��
//0��û���κΰ�������
//KEY0_PRES��KEY0����
//KEY1_PRES��KEY1����
//WKUP_PRES��WK_UP���� 
//ע��˺�������Ӧ���ȼ�,KEY0>KEY1>WK_UP!!
u8 KEY_Scan(u8 mode)
{	 
	static u8 key_up=1;//�������ɿ���־
	if(mode)key_up=1;  //֧������		  
	if(key_up&&(KEY0==0||KEY1==0))
	{
		delay_ms(10);//ȥ���� 
		key_up=0;
		if(KEY0==0)return KEY0_PRES;
		else if(KEY1==0)return KEY1_PRES;
	}else if(KEY0==1&&KEY1==1)key_up=1; 	     
	return 0;// �ް�������
}
