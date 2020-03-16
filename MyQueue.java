/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-03-16 12:19
 **/
class Node0{
    public int data;
    public Node0 next;
    public Node0(){}
    public Node0(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MyQueue<T> {
    public Node0 front;
    public Node0 rear;
    public int size;

    /**
     * 入队
     * @param data
     */
    public void offer(int data){
        Node0 node0  = new Node0(data);
        if(this.size==0){
            this.front = node0;
            this.rear = node0;
            this.size++;
            return;
        }
        this.rear.next = node0;
        this.rear = node0;
        this.size++;
    }

    /**
     * 出队
     * @return
     */
    public int poll(){
        if(empty()){
            throw new RuntimeException("队列为空！");
        }
        int data = this.front.data;
        this.front = this.front.next;
        this.size--;
        return data;
    }

    /**
     * 队首元素
     * @return
     */
    public int peek() {
        if (empty()) {
            throw new RuntimeException("队列为空！");
        }
        return this.front.data;
    }

    public boolean empty(){
        return this.size==0;
    }


    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.offer(1);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(10);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
    }
}
