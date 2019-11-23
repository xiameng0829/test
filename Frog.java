//青蛙跳台阶问题(提示, 使用递归)
//一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法
package Test;
public class Frog {
    public static void main(String[] args){
        for(int i=1;i<10;i++){
            System.out.println(frog(i));
        }
    }
    public static int frog(int n)
    {
        if(n==1||n==2)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        return frog(n-1) + frog(n-2);
    }
}
