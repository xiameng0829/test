/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-03-14 19:41
 **/
public class MyStack<T> {
    private T[] elem;
    private int size;
    public MyStack() {
        this.elem = (T[])new Object[10];
        this.size = 0;
    }

    /**
     * 入栈
     * @param val
     */
    public void push(T val){
        if(full()){
            return;
        }
        this.elem[this.size]=val;
        size++;
    }

    /**
     * 出栈
     */
    public T pop(){
        if(empty()){
            throw new RuntimeException("栈为空！");
        }
        T data = this.elem[this.size-1];
        this.size--;
        return data;
    }

    /**
     * 得到栈元素但不出栈
     */
    public T peek(){
        if(empty()){
            throw new RuntimeException("栈为空！");
        }
        T data = this.elem[this.size-1];
        return data;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean empty(){
        if(size==0){
            return true;
        }
        return false;
    }

    /**
     * 判断是否为满
     * @return
     */
    public boolean full(){
        if(size==elem.length){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
