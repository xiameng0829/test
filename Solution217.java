package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-04-16 16:04
 **/
public class Solution217 {
    /*
    给定一个整数数组，判断是否存在重复元素。
    如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
    输入: [1,2,3,1]
    输出: true
    */

    /*
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size()!=nums.length){
            return true;
        }
        return false;

    }
    */



    /*
    给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums[i] = nums[j]，并且i和j的差的绝对值至多为 k。

    输入: nums = [1,2,3,1], k = 3
    输出: true
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
