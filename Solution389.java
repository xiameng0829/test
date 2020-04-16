package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:practice
 * @description
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 例:
 * 输入：
 * s = "abcd"    t = "abcde"
 * 输出：e
 * @Author:xiameng
 * @create:2020-04-15 18:48
 **/
public class Solution389 {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        Character tmp = null;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(map1.containsKey(c1[i])){
                map1.put(c1[i],map1.get(c1[i])+1);
            }else{
                map1.put(c1[i],1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(map2.containsKey(c2[i])){
                map2.put(c2[i],map2.get(c2[i])+1);
            }else{
                map2.put(c2[i],1);
            }
        }

        for(Map.Entry<Character,Integer> entry : map2.entrySet()){
            if(!entry.getValue().equals(map1.get(entry.getKey()))){
                tmp = entry.getKey();
            }
        }

        return tmp;
    }
}
