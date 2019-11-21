public class Test {
	public static void main(String[] args){
		int n=10;
		int ret=factor(n);
		System.out.println(ret);	
	}
	public static int factor(int n)
	{		
		int sum=0;
		for(n=1;n<=10;n++)
		{
			sum+=n;
		}
		return sum;
	}

}
