#include<stdio.h>
#include<stdlib.h>
int main()
{
	int i=0;
	for(i=100;i<1000;i++)
	{
		int a,b,c;
		a=i/100;
		b=i/10%10;
		c=i%10;
		if(i==a*a*a+b*b*b+c*c*c)
		{
			printf("%d\t",i);
		}
	}
	system("pause");
	return 0;
}
	