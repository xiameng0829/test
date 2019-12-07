package List0;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-05 20:31
 **/
public class Test11 {
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

        SingleLinkedList s = new SingleLinkedList();
        /*
        s.addFirst(1);
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.addFirst(5);
        */
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);
        s.addLast(5);
        //s.addLast(1);
        //s.addLast(2);
        //s.addLast(3);
        //s.addLast(4);
        //s.addLast(5);
        /*
        System.out.println(s.contains(2));
        System.out.println(s.contains(6));
        System.out.println(s.get(1));
        s.set(2,10);

        s.addIndex(1,10);
        s.addIndex(0,20);
        s.addIndex(7,30);
        */

        s.remove(5);
        s.removeAll(1);


        /*
        Node temp = s.reverse(s.getFirst());
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
        */
        s.print();


    }
}
