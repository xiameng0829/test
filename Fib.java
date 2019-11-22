import java.util.Scanner;
public class Fib {
	public static void main(String[] args){
		
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int ret = fib(n);
		System.out.println("斐波那契数列第"+n+"项为："+ret);		
	}
	public static int fib(int n)
	{		
		if(n<3)
		{
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
}