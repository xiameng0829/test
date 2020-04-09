package LeetCode;

import java.util.*;

/**
 * @program:practice
 * @description
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @Author:xiameng
 * @create:2020-04-09 16:56
 **/
public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length < k  || k<=0){
            return null;
        }
        List<String> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (String i:words) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)){
                    return o1.compareTo(o2);
                }
                return map.get(o2)-map.get(o1);
            }
        });
        for (String s:map.keySet()){
            minHeap.add(s);
        }
        for (int i = 0; i < k; i++) {
            list.add(minHeap.poll());
        }
        return list;
    }
}
