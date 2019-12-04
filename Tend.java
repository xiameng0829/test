package code;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-04 22:44
 **/
class A{
    int i;
    void show1(){
        System.out.println("i:"+i);
    }
}

class B extends A{
    int k;
    void show2(){
        System.out.println("k:"+k);
        show1();
    }

    void sum(){
        System.out.println("i+k="+(i+k));
    }
}
public class Tend {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.i=10; //对父类对象成员的赋值
        System.out.println("父类：");
        a.show1();
        b.i=20; //对子类中继承得到的变量i赋值
        b.k=100;
        System.out.println("子类：");
        b.show2();
        System.out.println("sum:");
        b.sum();
    }
}
