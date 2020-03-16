package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program:practice
 * @description
 * 使用队列实现栈的下列操作：
 * 	push(x) -- 元素 x 入栈
 * 	pop() -- 移除栈顶元素
 * 	top() -- 获取栈顶元素
 * 	empty() -- 返回栈是否为空
 * @Author:xiameng
 * @create:2020-03-15 10:44
 **/
public class Solution225{
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int size;

    public Solution225(){
        this.qu1 = new LinkedList<>();
        this.qu2 = new LinkedList<>();
        this.size=0;
    }

    public void push(int x) {
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
        this.size++;
    }

    public int pop() {
        if(empty()){
            //throw new RuntimeException("栈为空！");
            return -1;
        }
        int e=0;
        if(!qu1.isEmpty()){
            //出size-1
            for (int i = 0; i < size-1; i++) {
                qu2.offer(qu1.poll());
            }
            e=qu1.poll();   //  删除
        }else {
            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            e=qu2.poll();   //删除
        }
        this.size--;
        return e;
    }

    public int top() {
        if(empty()){
            //throw new RuntimeException("栈为空！");
            return -1;
        }
        int e=0;
        if(!qu1.isEmpty()){
            //出size-1
            for (int i = 0; i < size; i++) {
                e=qu1.poll();
                qu2.offer(e);
            }

        }else {
            for (int i = 0; i < size; i++) {
                e=qu2.poll();
                qu1.offer(e);
            }
        }
        return e;
    }

    public boolean empty() {
        return size==0;
    }


    public static void main(String[] args) {
        Solution225 s = new Solution225();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}
