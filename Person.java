package Test;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-11-29 21:32
 **/
class People{
    int age=20;   //成员属性
    String name="张三";
    String sex;

    public void sleep(){  //成员方法
        System.out.println("睡觉");
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void showpeople(){
        System.out.println("我是"+name+"，今年"+age+"岁");
    }


    public  People(){
        System.out.println("无参数的构造方法");
    }
    public  People(int age){
        this.age=age;
        System.out.println("一个参数的构造方法 "+this.age);
    }
    public  People(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("两个参数的构造方法 "+this.name+this.age);
    }

    
    public static void play1(){
        System.out.println("play1");
    }
    public static void play2(){
        System.out.println("play2");
        play1();
    }
    public static void play3(){
        System.out.println("play3");
        play2();
    }
}
public class Person{
    public static void main(String[]args){
        People people=new People(); //实例化对象

        People people1=new People(18);
        People people2=new People("李四",30);

        people.sleep();   //调用
        people.eat();
        System.out.println(people.age);
        System.out.println(people.name);
        System.out.println(people.sex);
        people.showpeople();

        People.play1();
        People.play2();
        People.play3();
        }
}


