package com.company;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-02 22:32
 **/
interface CaleArea{
    double getArea();
}
class Circle implements CaleArea{
    double r=0;
    private final static double PI=3.14;
    public Circle(double r){
        this.r=r;
    }

    @Override
    public double getArea() {
        return PI*r*r;
    }
}

class Rectangle implements CaleArea{
    double length=0;
    double width=0;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }

    @Override
    public double getArea() {
        return length*width;
    }
}

public class Testshape {
    public static void main(String[] args) {
        Circle c=new Circle(4.5);
        Rectangle re=new Rectangle(3,2);
        System.out.println(c.getArea());
        System.out.println(re.getArea());
    }
}

