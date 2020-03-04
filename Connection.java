package String;

import java.util.Scanner;

/**
 * @program:class
 * @description :字符串连接
 * 输入 : abc def
 * 输出 : abcdef
 * @Author:xiameng
 * @create:2020-03-04 14:15
 **/
public class Connection {
    public static String  fun(String str){
        String[] ss = str.split(" ");
        String ret = " ";
        for (String s:ss) {
            ret+=s;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ret = fun(str);
        System.out.println(ret);
    }
}

