package LeetCode;

import java.util.*;

/**
 * @program:practice
 * @description：杨辉三角
 * @Author:xiameng
 * @create:2020-03-13 16:23
 **/
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows ==0) {
            return list;
        }
        list.add(new ArrayList<>());
        list.get(0).add(1);   //第一行的第一个元素
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = list.get(i-1);  //拿到前一行
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            for (int j =1; j < i; j++) {
                ret.add(prevRow.get(j-1)+prevRow.get(j));
            }
            ret.add(1);   //第二个元素
            list.add(ret);
        }
        return list;
    }
}
