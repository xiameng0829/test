package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program:practice
 * @description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Author:xiameng
 * @create:2020-04-11 16:15
 **/
public class Solution136 {
    /*异或
    public int singleNumber(int[] nums) {
        int tmp = 0;
        if(nums.length>1){
            for (int i = 0; i < nums.length; i++) {
                tmp = tmp^nums[i];
            }
        }
        return tmp;
    }
    */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                ret = nums[i];
                break;
            }
        }
        return ret;

    }
}

