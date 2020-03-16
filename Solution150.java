package LeetCode;

import java.util.Stack;

/**
 * @program:practice
 * @description：根据逆波兰表示法，求表达式的值。
 * @Author:xiameng
 * @create:2020-03-16 15:28
 **/
//当遇到运算符"+"、"-"、"*"、"/"时,从栈中pop出两个数字计算,否则将数字入栈;
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String i: tokens) {
            if (i.equals("+")) {
                int tmp = stack.pop()+stack.pop();
                stack.push(tmp);
            }else if(i.equals("-")){
                int tmp = stack.pop();
                stack.push(stack.pop()-tmp);
            }else if(i.equals("*")){
                int tmp = stack.pop()*stack.pop();
                stack.push(tmp);
            }else if(i.equals("/")){
                int tmp = stack.pop() ;
                stack.push(stack.pop()/tmp);
            }else {
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
}
