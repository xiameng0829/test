package LeetCode;

import java.util.*;
import java.util.stream.Collector;

/**
 * @program:practice
 * @description
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * 示例:
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * @Author:xiameng
 * @create:2020-04-09 16:07
 **/

public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length==0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-x) - Math.abs(o2-x);
            }
        });
        list = list.subList(0,k);
        Collections.sort(list);
        return list;
    }
}
