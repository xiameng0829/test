import java.util.*;

/**
 * @program:practice
 * @description：删除第一个字符串当中出现的第二个字符串中的字符
 * @Author:xiameng
 * @create:2020-03-11 19:50
 **/
public class TestDemo2 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        String str1 = "Welcome to bit";
        String str2 = "come";
        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();
        for (int i = 0; i < str1.length() ; i++) {
            char tmp = str1.charAt(i);
            if(!str2.contains(tmp+"")){
                list.add(tmp);
            }
        }
        //System.out.println("删除后的字符串为："+list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
