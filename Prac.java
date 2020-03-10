/**
 * @program:practice
 * @description：包装类
 * @Author:xiameng
 * @create:2020-03-10 20:24
 **/
public class Prac {
    public static void main(String[] args) {
        /*

        //在[-128，127]之间的数字，在第一次存储的是，会缓存到一个叫做cache的数组当中。
        //当第二次去拿的时候，拿到的就是缓存里面的数据
        //但是不在这个区间的时候，会每次产生新的对象的
        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;

        System.out.println(a==b);
        System.out.println(c==d);
        */

        /*
        int i =10;
        Integer i0 = Integer.valueOf(i);//装箱
        System.out.println(i0);
        double j = i0.doubleValue();//拆箱
        System.out.println(j);
        */

        int i=30;
        Integer a = i;             //自动装箱
        Integer b = (Integer)i;    //自动装箱

        double j = a;              //自动拆箱
        double k = (double)a;      //自动拆箱
        System.out.println(a);
        System.out.println(b);
        System.out.println(j);
        System.out.println(k);
    }
}
