package com.company;

/**
 * @program:class
 * @description  学生类
 * @Author:xiameng
 * @create:2019-12-02 20:50
 **/
class student {
    String sname = "西安财经大学";
    int id = 0001;
    String sex =  "男";
    String birthday = "1999-1-1";
    String name;
    int score;

    public void setName(String na) {
        name=na;
    }
    public void setScore(int sc) {
        score=sc;
    }

    public void show(){
        System.out.println("学校："+sname);
        System.out.println("学号："+id);
        System.out.println("性别："+sex);
        System.out.println("出生日期："+birthday);
        System.out.println("姓名："+name);
        System.out.println("成绩："+score);
    }
}

class Undergraduate extends student{
    String department;
    String major;

    public void setDepartment(String de) {
        department=de;
    }
    public void setMajor(String maj) {
        major=maj;
    }

    public void show1() {
        super.show();
        System.out.println("系名："+department);
        System.out.println("专业："+major);
    }
}

public class Student1{
    public static void main(String[] args){
        student std1 = new student();
        Undergraduate ud2 = new Undergraduate();
        ud2.setName("张三");
        ud2.setScore(100);
        ud2.setDepartment("软件工程");
        ud2.setMajor("信息学院");
        ud2.show1();
    }
}
