package code;
import java.util.Scanner;

/**
 * @program:class
 * @description
 * 输入描述: 输入两行，第一行一个整数，代表size,第二行一个字符串，代表chas
 * 输出描述: 输出一行字符串，代表翻转后的字符串。
 * @Author:xiameng
 * @create:2020-03-01 09:34
 **/
public class Main1{
    public static String reverse(String str,int left,int right) {
        char[] value = str.toCharArray();
        while(left<right){
            char temp=value[left];
            value[left]=value[right];
            value[right]=temp;
            left++;
            right--;
        }
        return  String.copyValueOf(value);
    }
    public static String func(String str,int k) {
        if(str==null || k<=0 || str.length()==0){
            return null;
        }
        str=reverse(str,0, k-1);
        str=reverse(str,k,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt();
        String str = sc.next();
        String s = func(str,k);
        System.out.println(s);
    }
}
