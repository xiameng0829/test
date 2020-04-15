package LeetCode;

import java.util.*;

/**
 * @program:practice
 * @description
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @Author:xiameng
 * @create:2020-04-15 15:08
 **/
public class Solution350 {

    //输入: nums1 = [1,2,2,1], nums2 = [2,2]
    //输出: [2]
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null){
            return null;
        }
        if(nums1==nums2){
            return nums1;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    set.add(nums2[j]);
                }
            }
        }
        int[] array = new int[set.size()];
        int k =0;
        for (int i :set1) {
            array[k++] = i;
        }
        return array;
    }
    */



    //输入: nums1 = [1,2,2,1], nums2 = [2,2]
    //输出: [2,2]
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null){
            return null;
        }
        if(nums1==nums2){
            return nums1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else {
                map.put(nums1[i],map.get(nums1[i])+1);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if(map.containsKey(nums2[j])){
                map.put(nums2[j],map.get(nums2[j])-1);
                if(map.get(nums2[j])==0){
                    map.remove(nums2[j]);
                }
                list.add(nums2[j]);
            }
        }

        int[] array = new int[list.size()];
        for (int i =0;i<list.size();i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
