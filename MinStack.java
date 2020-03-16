package LeetCode;

import java.util.Stack;

/**
 * @program:practice
 * @description
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 	push(x) -- 将元素 x 推入栈中。
 * 	pop() -- 删除栈顶的元素。
 * 	top() -- 获取栈顶元素。
 * 	getMin() -- 检索栈中的最小元素。
 *
 * @Author:xiameng
 * @create:2020-03-16 14:11
 **/
public class MinStack {
    private Stack<Integer>stack;
    private Stack<Integer>minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            //拿到栈顶元素和x比较
            int tmp = minStack.peek();
            if(tmp>=x){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if(!stack.empty()){
            int tmp = stack.pop();
           if(tmp==minStack.peek()){
               minStack.pop();
           }
        }
    }

    public int top() {
        if (stack.empty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
