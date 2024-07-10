#ifndef _USART3_H_
#define _USART3_H_

#include "stm32f10x.h"

void Usart3_Init(unsigned int baud);

void Usart_SendString2( USART_TypeDef * pUSARTx, char *str);

void Usart_SendHalfWord( USART_TypeDef * pUSARTx, uint16_t ch);

void Usart_SendByte( USART_TypeDef * pUSARTx, uint8_t ch);



#endif

