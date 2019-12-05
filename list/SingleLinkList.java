package list;

/**
 * @program:class
 * @description  单链表实现
 * @Author:xiameng
 * @create:2019-12-05 20:30
 **/

//Node类是车厢
class Node{
    private int data;
    Node next;
    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}

//火车
public class SingleLinkList {
    /*
    //每个结点内部存储的元素值
    private int data;
    private SingleLinkList next;

    public SingleLinkList(int data,SingleLinkList next){
        this.data=data;
        this.next=next;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkList getNext() {
        return next;
    }
    public void setNext(SingleLinkList next) {
        this.next = next;
    }
    */

    private int size;
    //永远指向火车尾车厢
    private Node last;
    //永远指向火车车头
    private Node first;

    public void add(int data){
        addLast(data);
    }
    //头插法
    public void addFirst(int data){
        //产生新节点
        Node node = new Node(data,null);
        if(first==null){
            first=last=node;
            size++;
            return;
        }
        node.next=first;
        first=node;
        size++;
    }

    //尾插法
    public void addLast(int data){
        //生产一个新车厢
        Node node = new Node(data,null);
        //此时火车还是空车厢
        if(last==null){
            first=last=null;
            size++;
            return;
        }
        //让最后一个车厢的next指向当前新节点
        last.next=node;
        last=node;
        size++;
    }

    //遍历一个链表
    public void print(){
        /*
        Node temp = first;
        while (temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
        */

        for (Node x = first;  x!=null ; x=x.next) {
            System.out.print(x.getData()+"、");
        }
    }
}
