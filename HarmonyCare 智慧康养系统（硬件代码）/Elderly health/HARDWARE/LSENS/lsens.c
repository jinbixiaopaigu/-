#include "lsens.h"
#include "delay.h"
/**********************************************

光敏传感器引脚：PA0


************************************************/
//初始化光敏传感器
void Lsens_Init(void)
{
  GPIO_InitTypeDef GPIO_InitStructure;
	
  RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA,ENABLE);//使能PORTF时钟	
	
	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_0;          //PA0 anolog输入
	GPIO_InitStructure.GPIO_Mode = GPIO_Mode_AIN;		//模拟输入引脚
	GPIO_Init(GPIOA, &GPIO_InitStructure);	
	T_Adc_Init();									 //ADC初始化
}
//读取光照的值
//0~100:0,最暗;100,最亮 
u8 Lsens_Get_Val(void)
{
	u32 temp_val=0;
	u8 t;
	for(t=0;t<LSENS_READ_TIMES;t++)
	{
		temp_val+=T_Get_Adc(LSENS_ADC_CHX);	 //读取ADC值
		delay_ms(5);
	}
	temp_val/=LSENS_READ_TIMES;            //得到平均值 
	
	if(temp_val>4000)temp_val=4000;
	return (u8)(100-(temp_val/40));
}












