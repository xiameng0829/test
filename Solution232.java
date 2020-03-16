package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program:practice
 * @description
 * 使用栈实现队列的下列操作：
 * 	push(x) -- 将一个元素放入队列的尾部。
 * 	pop() -- 从队列首部移除元素。
 * 	peek() -- 返回队列首部的元素。
 * 	empty() -- 返回队列是否为空。
 * @Author:xiameng
 * @create:2020-03-16 13:32
 **/
public class Solution232 {
    private Stack<Integer>s1;
    private Stack<Integer>s2;

    public Solution232() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
            s1.push(x);
    }

    public int pop() {
        if(s2.empty()){
            //把第一个栈里的元素放入第二个栈
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        int tmp = 0;
        if(!s2.empty()) {
            tmp = s2.pop();
        }else {
            System.out.println("队列为空！");
            return -1;
        }
        return tmp;
    }

    public int peek() {
        if(s2.empty()){
            //把第一个栈里的元素放入第二个栈
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        int tmp = 0;
        if(!s2.empty()) {
            tmp = s2.peek();
        }else {
            System.out.println("队列为空！");
            return -1;
        }
        return tmp;
    }

    public boolean empty() {
        if(s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }
}
