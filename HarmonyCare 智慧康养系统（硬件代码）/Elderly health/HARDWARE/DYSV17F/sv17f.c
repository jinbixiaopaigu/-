#include "sv17f.h"
/**********************************************

IO2：PA5
IO3：PA4


************************************************/
void SV17F_Init(void)
{
 
 GPIO_InitTypeDef  GPIO_InitStructure;
 	
 RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOB, ENABLE);	 //使能PB,PE端口时钟
	
 GPIO_InitStructure.GPIO_Pin = GPIO_Pin_0;				 //LED0-->PA.7 端口配置
 GPIO_InitStructure.GPIO_Mode = GPIO_Mode_Out_PP; 		 //推挽输出
 GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;		 //IO口速度为50MHz
 GPIO_Init(GPIOB, &GPIO_InitStructure);					 //根据设定参数初始化GPIOA.5
 GPIO_SetBits(GPIOB,GPIO_Pin_0);						 //PA.7 输出高
	
 GPIO_InitStructure.GPIO_Pin = GPIO_Pin_1;				 //LED1-->PC.13 端口配置
 GPIO_InitStructure.GPIO_Mode = GPIO_Mode_Out_PP; 		 //推挽输出
 GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;		 //IO口速度为50MHz
 GPIO_Init(GPIOB, &GPIO_InitStructure);					 //根据设定参数初始化GPIOC.5
 GPIO_SetBits(GPIOB,GPIO_Pin_1);						 //PA.13 输出高
	
  GPIO_InitStructure.GPIO_Pin = GPIO_Pin_3;				 //LED1-->PC.13 端口配置
 GPIO_InitStructure.GPIO_Mode = GPIO_Mode_Out_PP; 		 //推挽输出
 GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;		 //IO口速度为50MHz
 GPIO_Init(GPIOB, &GPIO_InitStructure);					 //根据设定参数初始化GPIOC.5
 GPIO_SetBits(GPIOB,GPIO_Pin_3);						 //PA.13 输出高
 
  GPIO_InitStructure.GPIO_Pin = GPIO_Pin_4;				 //LED1-->PC.13 端口配置
 GPIO_InitStructure.GPIO_Mode = GPIO_Mode_Out_PP; 		 //推挽输出
 GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;		 //IO口速度为50MHz
 GPIO_Init(GPIOB, &GPIO_InitStructure);					 //根据设定参数初始化GPIOC.5
 GPIO_SetBits(GPIOB,GPIO_Pin_4);						 //PA.13 输出高
}
 
