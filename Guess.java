
// 完成猜数字游戏
import java.util.Random;
import java.util.Scanner;
public class Guess{
	public static void main(String[] args){
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int toGuess = random.nextInt(100);
		
		while(true)
		{		
			System.out.println("请输入一个数字：");
			int num =sc.nextInt();
			if(num<toGuess)
			{
				System.out.println("猜小了");
			}
			else if(num>toGuess)
			{
				System.out.println("猜大了");
			}
			else
			{
				System.out.println("猜对了");
				break;
			}	
		}
		sc.close();
    }
}