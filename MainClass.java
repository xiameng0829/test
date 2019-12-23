package code;
import java.util.ArrayList;

/**
 * @program:class
 * @description：利用ArrayList实现完成一个栈结构
 * @Author:xiameng
 * @create:2019-12-22 22:13
 **/
class MyStack<T>{
    private ArrayList<T> al = new ArrayList<T>();
    public boolean push(T e){
        return al.add(e);
    }
    public T pop(){
        if(al.size()>0){
            return al.remove(al.size()-1);
        }else {
            return null;
        }
    }
    public int size(){
        return al.size();
    }
}
public class MainClass {
    public static void main(String[] args) {
        MyStack<String> ms = new MyStack<String>();
        ms.push("Tom");
        ms.push("Marry");
        ms.push("Jack");
        String element;
        while ((element = ms.pop()) != null){
            System.out.println(element);
        }
    }
}
