#ifndef  __KEY_H__
#define __KEY_H__

#include "stm32f10x.h"                  // Device header


void KEY_Init(void);

#define KEY0  GPIO_ReadInputDataBit(GPIOA,GPIO_Pin_6)//��ȡ����0
#define KEY1  GPIO_ReadInputDataBit(GPIOA,GPIO_Pin_7)//��ȡ����1

uint8_t KEY1_Get(void);//���ؼ�ֵΪ1��2��Ĭ��Ϊ0
uint8_t KEY2_Get(void);//���ؼ�ֵΪ1��2��Ĭ��Ϊ0

#define KEY0_PRES	1		//KEY0  
#define KEY1_PRES	2		//KEY1 
u8 KEY_Scan(u8 mode);  	//����ɨ�躯��

#endif      
