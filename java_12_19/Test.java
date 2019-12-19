package java_12_19;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-19 19:59
 **/
class Person{
    public void work(){
        System.out.println("人类工作");
    }
}
class Student extends Person{
    public void work(){
        System.out.println("学生学习");
    }
    public void study(){
        System.out.println("学生学java");
    }
}
class Teacher extends Person{
    public void work(){
        System.out.println("老师上课");
    }
}

public class Test {
    public static void main(String[] args) {
        Person per = new Person();
        Student stu = new Student();
        Teacher teacher = new Teacher();

        print(per);
        print(stu);
        print(teacher);
    }
    public static void print(Person per){
        if(per instanceof Student){
            Student stu = (Student) per;
            stu.study();
        }
        per.work();
    }
}

/*
public class Test {
    public static void main(String[] args) {
        Person per = new Person();
        Student stu=null;
        if(per instanceof Student){
            System.out.println("if语句");
        }else {
            System.out.println("else语句");
            per = new Student();
        }
        stu = (Student) per;
        stu.work();
    }
}
*/

