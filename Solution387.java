package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:practice
 * @description
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 例:
 * s = "leetcode"
 * 返回 0.
 * @Author:xiameng
 * @create:2020-04-15 17:24
 **/
public class Solution387 {
    public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
