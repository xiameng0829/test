//1.ʵ��һ����������ӡ�˷��ھ����ھ���������������Լ�ָ���� 
//����9�����9*9�ھ�������12�����12*12�ĳ˷��ھ��� 
#include<stdio.h>
void PrintTable(int n)
{
	int i = 0;
    for(i=1;i<=n;i++)
	{
		int j = 0;
		for(j=1;j<=i;j++)
		{
			printf("%d*%d=%-2d",i,j,i*j);
		}
		printf("\n");
	}
}
int main()
{
	int line = 0;
	scanf("%d",&line);
	PrintTable(line);
	return 0;
}
	
