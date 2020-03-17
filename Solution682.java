package LeetCode;

import java.util.Stack;

/**
 * @program:practice
 * @description：
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。

 * @Author:xiameng
 * @create:2020-03-17 16:03
 **/
public class Solution682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String i:ops) {
            if(i.equals("+")){
                int tmp = stack.pop();
                int score = tmp+stack.peek();
                stack.push(tmp);
                stack.push(score);
            }else if(i.equals("D")){
                int score = stack.peek()*2;
                stack.push(score);
            }else if(i.equals("C")){
                stack.pop();
            }else {
                stack.push(Integer.parseInt(i));
            }
        }
        int num = 0;
        for (int i:stack) {
            num += i ;
        }
        return num;
    }
}
