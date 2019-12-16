package java_12_15;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-15 11:13
 **/
class A{
    public A(){
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    static {
        System.out.println("3");
    }
}
public class B extends A {
    public B(){
        System.out.println("4");
    }
    {
        System.out.println("5");
    }
    static {
        System.out.println("6");
    }
    public static void main(String[] args) {
        System.out.println("7");
        new B();
        new B();
        System.out.println("8");
    }
}
