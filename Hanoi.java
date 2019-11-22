public class Hanoi{
	public static void main(String[] args){
		Han(6,"a","b","c");
		System.out.println("结束");	
	}
	public static void move(int n,String a,String c){
		System.out.println("将盘子"+n+"从"+a+"移到"+c);
	}
	public static void Han(int n,String a,String b,String c){
		if(n==1){
			move(1,a,c);
		}
		else{
			Han(n-1,a,c,b);
			move(n,a,c);
			Han(n-1,b,a,c);
		}		
	}
}