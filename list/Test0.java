package list;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-05 20:31
 **/
public class Test0 {
    public static void main(String[] args) {
        /*
        //生产每个结点
        SingleLinkList s1 = new SingleLinkList(1,null);
        SingleLinkList s2 = new SingleLinkList(2,null);
        SingleLinkList s3 = new SingleLinkList(3,null);
        //将第二个结点挂接在第一个结点之后
        s1.setNext(s2);
        s2.setNext(s3);
        //遍历链表结构
        SingleLinkList temp=s1;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
        */

        SingleLinkList s = new SingleLinkList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);

        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.print();
    }
}
