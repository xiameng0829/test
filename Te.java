package String;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2020-03-03 18:13
 **/
public class Te {
    /*
    //实现方法 split, 能够指定分割符将字符串拆分成字符串数组
    public static void main(String[] args) {
        String str = "hello and world";
        String[] result = str.split(" ",2);
        for (String s:result) {
            System.out.println(s);
        }
    }
    */

    /*
    //实现方法 replace, 能够替换字符串中的某个部分
    public static void main(String[] args) {
        String str  = "helloworld";
        System.out.println(str.replaceFirst("h","_"));
    }
    */

    /*
    //实现方法 indexOf, 能够找出字符串子串存在的位置
    public static void main(String[] args) {
        String str = "helloworld";
        System.out.println(str.indexOf("h"));
    }
    */

    /*
    //实现方法 contains, 能够判定字符串中是否包含子串
    public static void main(String[] args) {
        String str = "helloworld";
        System.out.println(str.contains("world"));
    }
    */

        //实现方法 compareTo, 能够实现按照字典序比较字符串大小
        public static void main(String[] args) {
            String str = "abcDEfg";
            String str1 = "ABCdef";
            System.out.println(str.compareTo(str1));
        }
}
