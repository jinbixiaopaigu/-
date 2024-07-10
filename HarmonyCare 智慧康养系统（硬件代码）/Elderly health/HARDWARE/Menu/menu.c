#include "menu.h"
#include "key.h"
#include "oled.h"
#include "stm32f10x.h"                  // Device header
#include "usart.h"

char dtbuf[50];
extern short aacx,aacy,aacz;		//加速度传感器原始数据
extern short gyrox,gyroy,gyroz;	//陀螺仪原始数据
extern float pitch,roll,yaw; 		//欧拉角
extern u8 adcx;
extern float Temp;
extern u8 HR,SPO2,blood;					//心率血氧数据
extern u8 oledshow;

void (*current_operation_index)(); //执行当前操作函数
uint8_t func_index = 0;
uint8_t hshow = 4;
uint8_t yshow = 1;
uint8_t key1;
uint8_t key2;



/*定义了索引数组，索引数组要配合主程序按键值进行选择*/
 Menu_table  table[26]=
{
    {0,1,3,(*show0)},      //一级界面	   体温心率血氧
    {1,2,4,(*show1)},      //一级界面    位置信息
    {2,0,5,(*show2)},      //一级界面    陀螺仪
		
		
    {3,3,0,(*show3)},     //二级界面     体温心率血氧血压		
    {4,4,1,(*show4)},     //二级界面     位置信息	
    {5,5,2,(*show5)},     //二级菜单     欧拉角
		
		{6,6,0,(*show6)},     //二级菜单     老人状态：异常

};


void  Menu_key_set(void)
{
	
  key1 = KEY1_Get();
  key2 = KEY2_Get();
	if(oledshow==1){
		func_index=6;
		OLED_Clear();
		oledshow=0;
	}else if(oledshow==2){
	  func_index=0;
		OLED_Clear();
		oledshow=0;
	}
  if(key2 == 1)
  {   
    func_index=table[func_index].next;//按键next按下后的索引号
		OLED_Clear();
  }
  if(key1 == 1)
  {
    func_index=table[func_index].enter;
		OLED_Clear();
  }

  current_operation_index=table[func_index].current_operation;//执行当前索引号所对应的功能函数。
  (*current_operation_index)();//执行当前操作函数
}

void show0(void)//第一页
{

	OLED_ShowCHinese(5,0,0);
	OLED_ShowCHinese(21,0,1);
	OLED_ShowCHinese(37,0,2);
	OLED_ShowCHinese(53,0,3);
	OLED_ShowString(69,0,(u8*)":",16);
	OLED_ShowCHinese(85,0,4);
	OLED_ShowCHinese(101,0,6);

	OLED_ShowCHinese(5,2,25);
	OLED_ShowCHinese(21,2,26);
	OLED_ShowCHinese(37,2,2);
	OLED_ShowCHinese(53,2,27);
	OLED_ShowString(69,2,(u8*)"<",16);
	
	OLED_ShowCHinese(5,4,15);
	OLED_ShowCHinese(21,4,16);
	OLED_ShowCHinese(37,4,17);
	OLED_ShowCHinese(53,4,18);
	
	OLED_ShowCHinese(5,6,41);
	OLED_ShowCHinese(21,6,42);
	OLED_ShowCHinese(37,6,43);
	OLED_ShowCHinese(53,6,27);
	
  
}


void show1(void)//第二页
{
//	  OLED_Show(8,0,(u8*)"老人状态:正常");
//	  OLED_Show(8,2,(u8*)"身体情况");
//		OLED_Show(8,4,(u8*)"位置信息<");
//	  OLED_Show(8,6,(u8*)"陀螺仪数据");
//	OLED_ShowString(5,0,(u8*)"laoren    ",16); 
	OLED_ShowCHinese(5,0,0);
	OLED_ShowCHinese(21,0,1);
	OLED_ShowCHinese(37,0,2);
	OLED_ShowCHinese(53,0,3);
	OLED_ShowString(69,0,(u8*)":",16);
	OLED_ShowCHinese(85,0,4);
	OLED_ShowCHinese(101,0,6);
	
	OLED_ShowCHinese(5,2,25);
	OLED_ShowCHinese(21,2,26);
	OLED_ShowCHinese(37,2,2);
	OLED_ShowCHinese(53,2,27);
	
	OLED_ShowCHinese(5,4,15);
	OLED_ShowCHinese(21,4,16);
	OLED_ShowCHinese(37,4,17);
	OLED_ShowCHinese(53,4,18);
	OLED_ShowString(69,4,(u8*)"<",16);
	
	OLED_ShowCHinese(5,6,41);
	OLED_ShowCHinese(21,6,42);
	OLED_ShowCHinese(37,6,43);
	OLED_ShowCHinese(53,6,27);
	
//	OLED_ShowString(5,2,(u8*)"Test1 ",16);
//	OLED_ShowString(5,4,(u8*)"Test2<",16);
//	OLED_ShowString(5,6,(u8*)"Test3",16); 
}


void show2(void)
{
//	  OLED_Show(8,0,(u8*)"老人状态:正常");
//	  OLED_Show(8,2,(u8*)"身体情况");
//		OLED_Show(8,4,(u8*)"位置信息");
//	  OLED_Show(8,6,(u8*)"陀螺仪数据<"); 
//  OLED_ShowString(5,0,(u8*)"laoren",16); 
	OLED_ShowCHinese(5,0,0);
	OLED_ShowCHinese(21,0,1);
	OLED_ShowCHinese(37,0,2);
	OLED_ShowCHinese(53,0,3);
	OLED_ShowString(69,0,(u8*)":",16);
	OLED_ShowCHinese(85,0,4);
	OLED_ShowCHinese(101,0,6);
	
	OLED_ShowCHinese(5,2,25);
	OLED_ShowCHinese(21,2,26);
	OLED_ShowCHinese(37,2,2);
	OLED_ShowCHinese(53,2,27);
	
	OLED_ShowCHinese(5,4,15);
	OLED_ShowCHinese(21,4,16);
	OLED_ShowCHinese(37,4,17);
	OLED_ShowCHinese(53,4,18);
	
OLED_ShowCHinese(5,6,41);
	OLED_ShowCHinese(21,6,42);
	OLED_ShowCHinese(37,6,43);
	OLED_ShowCHinese(53,6,27);
	OLED_ShowString(69,6,(u8*)"<",16);
	
//	OLED_ShowString(5,2,(u8*)"Test1",16);
//	OLED_ShowString(5,4,(u8*)"Test2",16);
//	OLED_ShowString(5,6,(u8*)"Test3<",16); 	
}

void show3(void)
{
//	  OLED_Show(8,0,(u8*)"体温:");
//	  OLED_Show(8,2,(u8*)"心率:");
//		OLED_Show(8,4,(u8*)"血氧:");
//	  OLED_Show(8,6,(u8*)"血压:");
	OLED_ShowCHinese(5,0,7); 
	OLED_ShowCHinese(21,0,8);
	OLED_ShowString(37,0,(u8*)":",16);
	OLED_ShowNumber(53,0,HR,3,16);
	OLED_ShowString(92,0,(u8*)"bmp",16);
	
	OLED_ShowCHinese(5,2,9); 
	OLED_ShowCHinese(21,2,10);
	OLED_ShowString(37,2,(u8*)":",16);
  OLED_ShowNumber(53,2,SPO2,3,16);
	OLED_ShowString(92,2,(u8*)"mol",16);

	
	OLED_ShowCHinese(5,4,11); 
	OLED_ShowCHinese(21,4,12);
	OLED_ShowString(37,4,(u8*)":",16);
	sprintf((char *)dtbuf,"%.1f",Temp);
	OLED_ShowString(53,4,(u8 *)dtbuf,16);
	OLED_ShowCHinese(92,4,30);
	
	OLED_ShowCHinese(5,6,13); 
	OLED_ShowCHinese(21,6,14);
	OLED_ShowString(37,6,(u8*)":",16);
	OLED_ShowNumber(53,6,blood,2,16);
	OLED_ShowString(73,6,(u8*)"Kpa",16);
//	OLED_ShowString(53,6,(u8 *)blood,16);
}

void show4(void)
{
  OLED_ShowCHinese(5,0,19); 
	OLED_ShowCHinese(21,0,21);
	OLED_ShowString(37,0,(u8*)":",16);
//	OLED_ShowString(53,0,(u8 *)Save_Data.N_S,16);
	OLED_ShowString(5,2,(u8 *)Save_Data.latitude,16);
	
	OLED_ShowCHinese(5,4,20); 
	OLED_ShowCHinese(21,4,21);
	OLED_ShowString(37,4,(u8*)":",16);
//	OLED_ShowString(53,4,(u8 *)Save_Data.E_W,16);
	OLED_ShowString(5,6,(u8 *)Save_Data.longitude,16);
	
}

void show5(void)//第二页第一项对应的第三页
{
//	  OLED_Show(32,0,(u8*)"陀螺仪");
//	        OLED_ShowString(5,0,(u8*)"tuoluoyi",16);
	OLED_ShowCHinese(32,0,38);
	OLED_ShowCHinese(48,0,39);
	OLED_ShowCHinese(64,0,40);
	
//	  sprintf((char *)str,"Pitch:%.2f",pitch);//0300
//		OLED_ShowString(5,2,(u8 *)str,16);
//		sprintf((char *)str,"Roll :%.2f",roll);//0300
//		OLED_ShowString(5,4,(u8 *)str,16);
//		sprintf((char *)str,"Yaw  :%.2f",yaw);//0300	
//		OLED_ShowString(5,6,(u8 *)str,16);
	OLED_ShowCHinese(5,2,31);
	OLED_ShowCHinese(21,2,32);
	OLED_ShowCHinese(37,2,37);
	OLED_ShowString(53,2,(u8*)":",16);
	sprintf((char *)dtbuf,"%.2f",pitch);
	OLED_ShowString(69,2,(u8 *)dtbuf,16);
	
	OLED_ShowCHinese(5,4,33);
	OLED_ShowCHinese(21,4,34);
	OLED_ShowCHinese(37,4,37);
	OLED_ShowString(53,4,(u8*)":",16);
	sprintf((char *)dtbuf,"%.2f",roll);
	OLED_ShowString(69,4,(u8 *)dtbuf,16);
	
	OLED_ShowCHinese(5,6,35);
	OLED_ShowCHinese(21,6,36);
	OLED_ShowCHinese(37,6,37);
	OLED_ShowString(53,6,(u8*)":",16);
	sprintf((char *)dtbuf,"%.2f",yaw);
	OLED_ShowString(69,6,(u8 *)dtbuf,16);
	
//	OLED_ShowNumber(60,2,gyrox,5,16);
//	OLED_ShowNumber(60,4,gyroy,5,16);
//	OLED_ShowNumber(60,6,gyroz,5,16);
}

void show6(void)
{
  OLED_ShowCHinese(23,0,0);
	OLED_ShowCHinese(39,0,1);
	OLED_ShowCHinese(55,0,2);
	OLED_ShowCHinese(71,0,3);
	OLED_ShowString(87,0,(u8*)":",16);
	OLED_ShowCHinese(27,4,5);
	OLED_ShowCHinese(70,4,6);
}
