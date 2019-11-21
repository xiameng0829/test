import java.util.Scanner;

/*
//递归求n的阶乘
public class Study {
	public static void main(String[] args){
		 
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();	
		System.out.println(n);
		int ret=factor(n);
		System.out.println(ret);	
	}
	public static int factor(int n)
	{		
		if(n==1)
		{
			return 1;
		}	
		return n*factor(n-1);
	}

}
*/



/*
//按顺序打印一个数字的每一位
public class Study{
	public static void main(String[] args){
		int n=1234;
		print(n);
	}
	public static void print(int n)
	{		
		if(n>9)
		{
			print(n/10);
		}
		System.out.println(n%10);
	}
}
*/

/*
//写一个递归方法，输入一个非负整数，返回组成它的数字之和. 
public class Study{
	public static void main(String[] args){
		int n=1234;
		int ret = sum(n);
		System.out.println(ret);
	}
	public static int sum(int n)
	{		
		if(n<10)
		{
			return n%10;
		}
		return n%10 + sum(n/10);
	}
}
*/
