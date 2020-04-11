package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program:practice
 * @description
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * @Author:xiameng
 * @create:2020-04-11 17:32
 **/
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (char s:S.toCharArray()) {
            if(set.contains(s)){
                count++;
            }
        }
        return count;
    }

}
