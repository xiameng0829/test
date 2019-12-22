package code;

import java.util.Scanner;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-22 20:59
 **/
public class CharacterCount {
    public static void main(String[] args) {
        int bigCount=0;
        int smallCount=0;
        int numberCount=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str=sc.nextLine();
        char[] ch=str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c=ch[i];
            if(Character.isUpperCase(c)){
                bigCount++;
            }else if(Character.isLowerCase(c)){
                smallCount++;
            }else if(Character.isDigit(c)){
                numberCount++;
            }
        }
        System.out.println(bigCount);
        System.out.println(smallCount);
        System.out.println(numberCount);
    }
}
