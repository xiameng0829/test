package packaging;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-03 21:07
 **/
public class Test{
    public static void main(String[]args){
        Myarray myarray=new Myarray(3);
        myarray.add(1);
        myarray.add(2);
        myarray.add(3);
        myarray.add(4);
        //索引非法
        //myarray.add(5);
        //从中间位置插入
        myarray.add(1,10);
        //尾插
        //myarray.add(6,20);
        //头插
        //myarray.add(0,100);
        myarray.find(22);
        myarray.contains(1);
        myarray.remove(4);
        myarray.print();

    }

}
