package code;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-21 20:47
 **/
class Character{
    //判断给定的字符是否是大写字符
    public static boolean isUpperCase(char c) {
        if(c>='A' && c<='Z'){
            return true;
        }
        return false;
    }

    //判断给定的字符是否是小写字符
    public static boolean isLowerCase(char c) {
        if(c>='a' && c<='z'){
            return true;
        }
        return false;
    }

    //判断给定的字符是否是数字字符   ASIIC码  48——57数字字符
    public static boolean isDigit(char c) {
        if(c<48 || c>57){
            return false;
        }
        return true;
    }

    //把给定的字符转化为大写字符
    public static char toUpperCase(char c) {
        if(c>='a' && c<='z'){
            c-=32;
        }
        return c;
    }

    //把给定的字符转化为小写字符
    public static char toLowerCase(char c)
    {
        if(c>='A' && c<='Z'){
            c+=32;
        }
        return c;
    }
}

public class CharacterDemo {
    public static void main(String[] args){
        System.out.println(Character.isUpperCase('a'));  //判断给定的字符是否是大写字符
        System.out.println(Character.isLowerCase('a'));  //判断给定的字符是否是小写字符
        System.out.println(Character.isDigit('0'));		 //判断给定的字符是否是数字字符
        System.out.println(Character.toUpperCase('a'));  //把给定的字符转化为大写字符
        System.out.println(Character.toLowerCase('A'));  //把给定的字符转化为小写字符
    }
}

