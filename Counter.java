package code;

/**
 * @program:class
 * @description：对象计数器
 * @Author:xiameng
 * @create:2019-12-06 23:29
 **/
//当新创建一个对象时，计数器自动加1，当删除一个该类的对象时，计数器自动减1。
public class Counter {
    public static int num=0;
    public Counter(){
        num++;
        System.out.println(num);
    }
    public static void Delete(Counter o){
        num--;
        System.out.println("delete:"+num);
        o=null;
        System.gc();  //回收无用的对象
    }
    public static void main(String[] args) {
        Counter[] arr=new Counter[5];
        for (Counter a:arr) {
            a=new Counter();
        }
        Counter.Delete(arr[0]);
    }
}
