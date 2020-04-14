package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:practice
 * @description
 *
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
例 :
输入: s = "egg", t = "add"
输出: true
 * @Author:xiameng
 * @create:2020-04-14 17:21
 **/
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if(map.get(si) == null){
                if(map.containsValue(ti)){
                    return false;
                }
                map.put(si,ti);
            }else if(map.get(si)!=ti){
                return false;
            }
        }
        return true;
    }
}
