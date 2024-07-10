#ifndef __ATGM336H_H
#define __ATGM336H_H

#include "usart.h"
#include "sys.h"


void errorLog(int num);
// 解包函数
void parseGpsBuffer(void);

// 打印函数
void printGpsBuffer(void);


#endif	// __ATGM336H_H


