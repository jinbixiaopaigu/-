#ifndef __ATGM336H_H
#define __ATGM336H_H

#include "usart.h"
#include "sys.h"


void errorLog(int num);
// �������
void parseGpsBuffer(void);

// ��ӡ����
void printGpsBuffer(void);


#endif	// __ATGM336H_H


