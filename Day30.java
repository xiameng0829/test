package packaging;

import java.util.Scanner;
/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-11-30 11:48
 **/
//编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
 /*
class Calculator{
    double num1;
    double num2;
    public void add(){
        System.out.println(num1+"+"+num2+"="+(num1+num2));
    }
    public void cut(){
        System.out.println(num1+"-"+num2+"="+(num1-num2));
    }
    public void mul(){
        System.out.println(num1+"*"+num2+"="+(num1*num2));
    }
    public void div(){
        System.out.println(num1+"/"+num2+"="+(num1/num2));
    }
}
public class Day30 {
    public static void main(String[] args) {
        Calculator ca=new Calculator();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入两个数字：");
        ca.num1=sc.nextDouble();
        ca.num2=sc.nextDouble();
        ca.add();
        ca.cut();
        ca.mul();
        ca.div();
    }
}
*/


//设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
/*
class Function{
    int age;
    String name;
    String sex;
    public Function(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

    public void eat(){
        System.out.println(name+age+"，正在吃饭");
    }
    public void sleep(){
        System.out.println(name+age+"，正在睡觉");
    }
    public void study(){
        System.out.println(name+age+"，正在学习");
    }
    public void show(){
        System.out.println("我的名字是"+name+",我的年龄是"+age+"岁，我的性别是"+sex);
    }
}
public class Day30{
    public static void main(String[] args) {
        Function fun = new Function("张三",20,"男");
        Function fun1 = new Function("小芳",18,"女");
        fun.eat();
        fun1.study();
        fun.show();
        fun1.show();
    }
}
*/


// 实现交换两个变量的值。要求：需要交换实参的值。
class Number{
    double num1;
    double num2;
    public void change(){
        double temp=num1;
        num1=num2;
        num2=temp;
        System.out.println("交换之后为：num1="+num1+",num2="+num2);
    }
}
public class Day30{
    public static void main(String[] args) {
        Number nu=new Number();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数：");
        nu.num1=sc.nextDouble();
        nu.num2=sc.nextDouble();
        nu.change();
    }
}
