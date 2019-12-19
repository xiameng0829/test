package java_12_19;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-19 19:44
 **/
class A0{
    public A0(){
        func();
    }
    public void func(){
        System.out.println("This is A");
    }
}
public class B0 extends A0{
    int num = 10;
    public B0(){

    }
    public void func(){
        System.out.println("This is B:"+num);
    }

    public static void main(String[] args) {
        new B0().func();
    }
}
