/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-11-30 09:24
 **/
class Lesson{
    int age;
    String name;
    static String country; //方法区
    //final int test=0; //堆上
    final static int test=0; //方法区
    /*
    public Lesson(){
        age=10;
        System.out.println("2222");
    }
    {//构造代码块
        age=20;
        System.out.println("1111");
    }
    */

    public Lesson(){
        System.out.println("1.Lesson的构造方法");
    }
    {
        System.out.println("2.Lesson的构造块");
    }
    static {//执行一次
        System.out.println("3.Lesson的静态块");
    }


    public void show(){
        System.out.println(age);
        System.out.println(name);
        System.out.println(country);
        System.out.println(test);
    }
    /*public  Lesson(){//构造方法对属性初始化
        age=20;
        name="zs";
        country="中国";
        System.out.println(test);
    }*/
    public static void fun(){
        System.out.println(country);
        System.out.println(test);
    }

}
public class Review {
    public Review(){
        System.out.println("1.");
    }
    {
        System.out.println("2.");
    }
    static {//执行一次
        System.out.println("3.");
    }
    public static void main(String[] args) {
        //Lesson lesson=new Lesson();
        //lesson.show();
        //主类中的静态代码块优先于主方法执行
        System.out.println("4");
        Review review=new Review();
        Review review1=new Review();
        //Lesson lesson1=new Lesson();
       // Lesson lesson2=new Lesson();
    }
}
