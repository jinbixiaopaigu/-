#include "timer.h"
#include "led.h"
#include "oled.h"
#include "usart.h"
#include "beep.h"
#include "menu.h"
#include "inv_mpu.h"
#include "mpu6050.h"
#include "delay.h"
#include "sv17f.h"
#include "KEY.h"
#include "max30102.h" 
#include "maxiic.h"
#include "MLX90614.h"
/**********************************************

定时器中断，0.5秒刷新一次
定时器3用来报警
定时器4用来刷新OLED显示屏

************************************************/

extern u8 Flag,Flag1,Flag2,Flag3;
extern int nor1;  //报警 1.跌倒报警
extern int nor2;  //报警 2.心率报警
extern int nor3;  //报警 3.体温报警  
extern int nor4;  //报警 4.血压报警 
extern int nor5;  //报警 5.手动报警
extern int blood;
//float Temp;
extern u8 HR,SPO2;
//short aacx,aacy,aacz;		//加速度传感器原始数据
//float pitch,roll,yaw; 		//欧拉角
char valuesBuff[15];
//u8 oledshow=0;
extern int nor1,nor5;
//unsigned long time=0;
//int time=0;
//u8 key = 0;//按键数

void TIM3_Int_Init(u16 arr,u16 psc)
{
    TIM_TimeBaseInitTypeDef  TIM_TimeBaseStructure;
	NVIC_InitTypeDef NVIC_InitStructure;

	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM3, ENABLE); //时钟使能
	
	//定时器TIM3初始化
	TIM_TimeBaseStructure.TIM_Period = arr; //设置在下一个更新事件装入活动的自动重装载寄存器周期的值	
	TIM_TimeBaseStructure.TIM_Prescaler =psc; //设置用来作为TIMx时钟频率除数的预分频值
	TIM_TimeBaseStructure.TIM_ClockDivision = TIM_CKD_DIV1; //设置时钟分割:TDTS = Tck_tim
	TIM_TimeBaseStructure.TIM_CounterMode = TIM_CounterMode_Up;  //TIM向上计数模式
	TIM_TimeBaseInit(TIM3, &TIM_TimeBaseStructure); //根据指定的参数初始化TIMx的时间基数单位
 
	TIM_ITConfig(TIM3,TIM_IT_Update,ENABLE ); //使能指定的TIM3中断,允许更新中断

	//中断优先级NVIC设置
	NVIC_InitStructure.NVIC_IRQChannel = TIM3_IRQn;  //TIM3中断
	NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority = 0;  //先占优先级0级
	NVIC_InitStructure.NVIC_IRQChannelSubPriority = 3;  //从优先级3级
	NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE; //IRQ通道被使能
	NVIC_Init(&NVIC_InitStructure);  //初始化NVIC寄存器

	TIM_Cmd(TIM3, ENABLE);  //使能TIMx					 
}
//定时器3中断服务程序
void TIM3_IRQHandler(void)   //TIM3中断
{
	static u8 value=0;
	if (TIM_GetITStatus(TIM3, TIM_IT_Update) != RESET)  //检查TIM3更新中断发生与否
		{	
		TIM_ClearITPendingBit(TIM3, TIM_IT_Update);  //清除TIMx更新中断标志		OLED_ShowChinese(0,0,10,8,1);		  			
					if(Flag==1)
			   {					
					 value++;
				   IO2=0;      //触发语音播报
					 LED1=!LED1;
					 BEEP=!BEEP;					 
				if(value>=30){
					value=0;
					Flag=0;
					LED1=1;
				  BEEP=0;
					nor1=1;     //报警上传标志  1.异常  0.正常
					IO2=1;      //语音播报关闭
				}				
      }else if(Flag==2){
				IO2=1;      //语音播报关闭
				LED1=1;
				BEEP=0;
				value=0;
			}	 
		}
}
void TIM2_Int_Init(u16 arr,u16 psc)
{
  TIM_TimeBaseInitTypeDef  TIM_TimeBaseStructure;
	NVIC_InitTypeDef NVIC_InitStructure;

	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM2, ENABLE); //时钟使能
	
	//定时器TIM3初始化
	TIM_TimeBaseStructure.TIM_Period = arr; //设置在下一个更新事件装入活动的自动重装载寄存器周期的值	
	TIM_TimeBaseStructure.TIM_Prescaler =psc; //设置用来作为TIMx时钟频率除数的预分频值
	TIM_TimeBaseStructure.TIM_ClockDivision = TIM_CKD_DIV1; //设置时钟分割:TDTS = Tck_tim
	TIM_TimeBaseStructure.TIM_CounterMode = TIM_CounterMode_Up;  //TIM向上计数模式
	TIM_TimeBaseInit(TIM2, &TIM_TimeBaseStructure); //根据指定的参数初始化TIMx的时间基数单位
 
	TIM_ITConfig(TIM2,TIM_IT_Update,ENABLE ); //使能指定的TIM3中断,允许更新中断

	//中断优先级NVIC设置
	NVIC_InitStructure.NVIC_IRQChannel = TIM2_IRQn;  //TIM3中断
	NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority = 0;  //先占优先级0级
	NVIC_InitStructure.NVIC_IRQChannelSubPriority = 3;  //从优先级3级
	NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE; //IRQ通道被使能
	NVIC_Init(&NVIC_InitStructure);  //初始化NVIC寄存器


	TIM_Cmd(TIM2, ENABLE);  //使能TIMx					 
}
//定时器2中断服务程序
void TIM2_IRQHandler(void)   //TIM2中断
{
	if (TIM_GetITStatus(TIM2, TIM_IT_Update) != RESET)  //检查TIM2更新中断发生与否
		{	
			
		TIM_ClearITPendingBit(TIM2, TIM_IT_Update  );  //清除TIMx更新中断标志		OLED_ShowChinese(0,0,10,8,1);					
							
		}
}



//void TIM4_Int_Init(u16 arr,u16 psc)
//{
//  TIM_TimeBaseInitTypeDef  TIM_TimeBaseStructure;
//	NVIC_InitTypeDef NVIC_InitStructure;

//	RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM4, ENABLE); //时钟使能
//	
//	//定时器TIM4初始化
//	TIM_TimeBaseStructure.TIM_Period = arr; //设置在下一个更新事件装入活动的自动重装载寄存器周期的值	
//	TIM_TimeBaseStructure.TIM_Prescaler =psc; //设置用来作为TIMx时钟频率除数的预分频值
//	TIM_TimeBaseStructure.TIM_ClockDivision = TIM_CKD_DIV1; //设置时钟分割:TDTS = Tck_tim
//	TIM_TimeBaseStructure.TIM_CounterMode = TIM_CounterMode_Up;  //TIM向上计数模式
//	TIM_TimeBaseInit(TIM4, &TIM_TimeBaseStructure); //根据指定的参数初始化TIMx的时间基数单位
// 
//	TIM_ITConfig(TIM4,TIM_IT_Update,ENABLE ); //使能指定的TIM3中断,允许更新中断

//	//中断优先级NVIC设置
//	NVIC_InitStructure.NVIC_IRQChannel = TIM4_IRQn;  //TIM3中断
//	NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority = 0;  //先占优先级0级
//	NVIC_InitStructure.NVIC_IRQChannelSubPriority = 3;  //从优先级3级
//	NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE; //IRQ通道被使能
//	NVIC_Init(&NVIC_InitStructure);  //初始化NVIC寄存器


//	TIM_Cmd(TIM4, ENABLE);  //使能TIMx					 
//}
////定时器4中断服务程序
//void TIM4_IRQHandler(void)   //TIM2中断
//{
//	
//	
//	if (TIM_GetITStatus(TIM4, TIM_IT_Update) != RESET)  //检查TIM2更新中断发生与否
//		{	
////					MAX30102_get(&HR,&SPO2);	
//					
////			if(Flag==1)
////			{					
////					value++;
////				   IO2=0;      //触发语音播报
//////					BEEP=1;
////					LED1=0;
////				 delay_ms(3000);
//////				  BEEP=0;
////					LED1=1;
////				
////				if(value>=10){
////				  value=0;
////					Flag=0;
////					Flag2=1;
////					IO2=1;      //触发语音播报
////				}				
////				if(Flag1==1){
////				   value=0;
////					Flag=0;
////						IO2=1;      //触发语音播报
////				}  //按键值				
////   }
//			     
//					
//		TIM_ClearITPendingBit(TIM4, TIM_IT_Update  );  //清除TIMx更新中断标志						
//					
//		}
//}












