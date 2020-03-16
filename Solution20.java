package LeetCode;

import java.util.Stack;

/**
 * @program:practice
 * @description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 	左括号必须用相同类型的右括号闭合。
 * 	左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author:xiameng
 * @create:2020-03-15 09:56
 **/
public class Solution20 {
    public boolean isVaild(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if(stack.empty()){
                    System.out.println("右括号多！");
                    return false;
                }else {
                    char ch = stack.peek();
                    if(ch=='(' && s.charAt(i)==')' || ch=='[' && s.charAt(i)==']' ||ch=='{' && s.charAt(i)=='}'){
                        stack.pop();
                    }else {
                        System.out.println("右括号匹配错误！");
                        return false;
                    }
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
