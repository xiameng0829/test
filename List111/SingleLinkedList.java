package List111;

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
public class SingleLinkedList {
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

    public Node getFirst(){
        return first;
    }
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
            last=first=node;
            size++;
            return;
        }
        //让最后一个车厢的next指向当前新节点
        last.next=node;
        last=node;
        size++;
    }

    /**
     * 在任意位置索引处插入新的节点data
     * @param index
     * @param data
     */
     public void addIndex(int index,int data){
        if(index<0 || index>size){
            System.out.println("索引非法");
            return;
        }else if(index==size){
            addLast(data);
        }else if(index==0){
            addFirst(data);
        }else {
            //在中间位置插入新节点
            //产生新节点等待插入
            Node node=new Node(data,null);
            //找到待插入位置的前驱结点
            Node prev=getIndexNode(index-1);
            //将新节点插入到前驱结点后方
            node.next=prev.next;
            prev.next=node;
            size++;
        }
     }

    /**
     * 根据用户传入的索引值获取节点值
     * @param index
     * @return
     */
    public int get(int index){
        if(rangeCheck(index)){
            Node node = getIndexNode(index);
            return node.getData();
        }
        return -1;
    }

    public boolean contains(int data){
        Node temp=first;
        while (temp!=null){
            if(temp.getData()==data){
                System.out.println("找到元素");
                return true;
            }
            temp=temp.next;
        }
        System.out.println("没有找到指定元素");
        return false;
    }

    /**
     *  修改指定index位置的节点为data值
     * @param index
     * @param data
     */
    public void set(int index,int data){
        if(rangeCheck(index)){
            Node node = getIndexNode(index);
            node.setData(data);
        }
    }

    public void remove(int data){
        /*
        if(first.getData()==data){
            first=first.next;
            size--;
            return;
        }
        else{
            Node prev=first;
            while (prev.next!=null){
                if(prev.next.getData()==data){
                    prev.next=prev.next.next;
                    size--;
                    return;
                }
                else{
                    prev=prev.next;
                }
            }
        }
        */

        //虚拟头结点data
        Node dummyHead=new Node(data-1,null);
        dummyHead.next=first;
        Node temp=dummyHead;
        while (temp.next!=null){
            if(temp.next.getData()==data){
                //此时temp就是待删除的前驱结点
                temp.next=temp.next.next;
                size--;
                break;
            }
            else{
                temp=temp.next;
            }
        }
        first=dummyHead.next;
    }

    /**
     * 删除所有值为data的节点
     * @param data
     */
    public void removeAll(int data){
        /*
        while (first!=null && first.getData()==data){
            first=first.next;
            size--;
        }
        if(first==null){
            return;
        }else {
            Node prev=first;
            while (prev.next!=null){
                if(prev.next.getData()==data){
                    prev.next=prev.next.next;
                    size--;
                }else{
                    prev=prev.next;
                }
            }
        }
        */

        //虚拟头结点
        Node dummyHead=new Node(data-1,null);
        dummyHead.next=first;
        Node prev=dummyHead;
        while (prev.next!=null){
            if(prev.next.getData()==data){
                prev.next=prev.next.next;
                size--;
            }else {
                prev=prev.next;
            }
        }
        first=dummyHead.next;
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

    //根据用户传入的index值取得对应的Node结点
    private Node getIndexNode(int index){
        Node temp=first;
        for (int i = 0; i < index; i++) {
        temp = temp.next;
        }
        return temp;
    }

    //判断index合法性
    private boolean rangeCheck(int index){
        if(index==0 || index>=size){
            System.out.println("索引非法");
            return false;
        }
        return true;
    }

    // 原链表: 1->2->3->4->5->null
    // 回文链表: 5->4->3->2->1->null
    public Node reverse(Node head){
        //判断边界
        if(head==null || head.next==null){
            return head;
        }
        //当前链表不为空，遍历当前链表，产生新节点，头插另一个链表
        Node newHead = new Node(head.getData(),null);
        //遍历原先链表
        while (head.next!=null){
            //产生新节点
            Node node = new Node(head.next.getData(),null);
            //将新节点头插到新链表尾部
            node.next=newHead;
            newHead=node;
            head=head.next;
        }
        head.next=null;
        return newHead;
    }
}
