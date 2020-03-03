package String;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2020-03-03 14:54
 **/
public class Str {
    public static void main(String[] args) {

        /*
        String s = "abcdef";
        s = "defgh";
        s = s+"Hello";
        System.out.println(s);
        */

        StringBuffer sb = new StringBuffer();
        sb.append("Hello").append("World");
        System.out.println(sb.delete(5,10));    //删除
        System.out.println(sb.insert(0,"你好"));  //插入

        /*
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append("World");
        System.out.println(stringBuilder);
        */


    }
}