
//硬件驱动
#include "usart.h"
#include "delay.h"

//C库
#include <stdarg.h>
#include <string.h>
#include <stdio.h>

/**************************************************************************/
//函数名称：串口3初始化
//函数作用：用于SIM900A传输数据
//函数名称：Usart3_Init();
//入口参数：baud：设定的波特率
/*接线说明：TX-PB10		RX-PB11*/
//修改日期：2022年1月25日
//作者：    大屁桃
/**************************************************************************/
void Usart3_Init(unsigned int baud)
{
		GPIO_InitTypeDef GPIO_InitStructure;                         
		USART_InitTypeDef USART_InitStructure;
		NVIC_InitTypeDef NVIC_InitStructure;
		
		RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOB , ENABLE);
		RCC_APB1PeriphClockCmd(RCC_APB1Periph_USART3 , ENABLE); 
		
		GPIO_InitStructure.GPIO_Pin = GPIO_Pin_10;               
		GPIO_InitStructure.GPIO_Mode = GPIO_Mode_AF_PP;
		GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;
		GPIO_Init(GPIOB , &GPIO_InitStructure);
		
		GPIO_InitStructure.GPIO_Pin = GPIO_Pin_11;             
		GPIO_InitStructure.GPIO_Mode = GPIO_Mode_IN_FLOATING;
		GPIO_Init(GPIOB , &GPIO_InitStructure);
		
		USART_InitStructure.USART_BaudRate = baud;               
		USART_InitStructure.USART_WordLength = USART_WordLength_8b;
		USART_InitStructure.USART_StopBits = USART_StopBits_1;
		USART_InitStructure.USART_Parity = USART_Parity_No;
		USART_InitStructure.USART_HardwareFlowControl = USART_HardwareFlowControl_None;
		USART_InitStructure.USART_Mode = USART_Mode_Rx | USART_Mode_Tx;
		USART_Init(USART3,&USART_InitStructure);                   
		
		NVIC_InitStructure.NVIC_IRQChannel = USART3_IRQn;         
		NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority = 0; 
		NVIC_InitStructure.NVIC_IRQChannelSubPriority = 2;       
		NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE;         
		NVIC_Init(&NVIC_InitStructure);                         
		
		USART_ITConfig(USART3, USART_IT_RXNE, ENABLE);           
		USART_Cmd(USART3,ENABLE);
}


/**************************************************************************/
//函数名称：串口3中断服务函数
//函数作用：用于接收SIM900A返回的OK
//函数名称：USART3_IRQHandler();
//入口参数：空
//最终修改日期：2022年1月25日
//作者：    大屁桃
/**************************************************************************/
u8 i3=0;
u8 res3=0;
u8 Usart3_buff[128];       
void USART3_IRQHandler(void)
{
	
	if(USART_GetITStatus(USART3, USART_IT_RXNE) != RESET) //接收中断
	{
		res3 = USART_ReceiveData(USART3); 
		Usart3_buff[i3]=res3;             //将接收的数据存放于数组中
		i3++;
	  if(Usart3_buff[i3]=='K')    //注意这种写法
		{
			i3=0;
		}
		USART_ClearFlag(USART3, USART_FLAG_RXNE);
	}
	
}

/****************************************************************串口常用函数**************************************************************/

/*****************  发送一个16位数 **********************/
void Usart_SendHalfWord( USART_TypeDef * pUSARTx, uint16_t ch)
{
	uint8_t temp_h, temp_l;
	
	/* 取出高八位 */
	temp_h = (ch&0XFF00)>>8;
	/* 取出低八位 */
	temp_l = ch&0XFF;
	
	/* 发送高八位 */
	USART_SendData(pUSARTx,temp_h);	
	while (USART_GetFlagStatus(pUSARTx, USART_FLAG_TXE) == RESET);
	
	/* 发送低八位 */
	USART_SendData(pUSARTx,temp_l);	
	while (USART_GetFlagStatus(pUSARTx, USART_FLAG_TXE) == RESET);	
}
/*****************  发送一个字符 **********************/
void Usart_SendByte( USART_TypeDef * pUSARTx, uint8_t ch)
{
	/* 发送一个字节数据到USART */
	USART_SendData(pUSARTx,ch);
		
	/* 等待发送数据寄存器为空 */
	while (USART_GetFlagStatus(pUSARTx, USART_FLAG_TXE) == RESET);	
}

/*****************  发送字符串 **********************/
void Usart_SendString2( USART_TypeDef * pUSARTx, char *str)
{
	unsigned int k=0;
  do 
  {
      Usart_SendByte( pUSARTx, *(str + k) );
      k++;
  } while(*(str + k)!='\0');
  
  /* 等待发送完成 */
  while(USART_GetFlagStatus(pUSARTx,USART_FLAG_TC)==RESET)
  {}
}
