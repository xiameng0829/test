import java.util.*;

/**
 * @program:List
 * @description ：List（线性表）常见方法
 * @Author:xiameng
 * @create:2020-03-11 14:39
 **/
public class MyArrayList{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");   //尾插
        list.add(0,"zhangsan");  //将e插入到index

        List<String> list1 = new ArrayList<>();
        list1.add("wangwu");
        list1.add("wangwu");
        list1.add("good");
        list.addAll(list1);   //添加一个整体的list1

        list.remove(0); //删除index位置元素
        list.remove("wangwu");  //删除遇到的第一个元素
        //
        System.out.println(list);   //[hello, wangwu, good]

        String ret = list.get(0);   //获取下标index位置元素
        System.out.println(ret);

        list.set(1,"abcd");     //将下标index位置元素替换
        System.out.println(list);

        /*
        list.clear();           //清空
        System.out.println(list);
        */

        System.out.println(list.contains("zhangsan"));  //判断某个元素是否在线性表中

        System.out.println(list.indexOf("hello"));      //返回第一个o所在下标
        System.out.println(list.lastIndexOf("hello"));  //返回最后一个o所在下标

        System.out.println(list.subList(0,2));      //截取部分list
    }
}
