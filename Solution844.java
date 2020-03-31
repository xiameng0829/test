package LeetCode;

import java.util.Stack;

/**
 * @program:practice
 * @description：给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 例如：
 *输入：S = "ab#c", T = "ad#c"
 *输出：true
 *解释：S 和 T 都会变成 “ac”。
 * @Author:xiameng
 * @create:2020-03-18 15:17
 **/

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)!='#'){
                s.push(S.charAt(i));
            }else if(S.charAt(i)=='#' && !s.isEmpty()){
                 s.pop();
            }
        }

        for (int j = 0; j < T.length(); j++) {
            if(T.charAt(j)!='#'){
                t.push(T.charAt(j));
            }else if(T.charAt(j)=='#' && !t.isEmpty()){
                t.pop();
            }
        }
       return s.equals(t);
    }
}
