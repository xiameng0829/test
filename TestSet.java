package com.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program:practice
 * @description: Set的常见方法
 * @Author:xiameng
 * @create:2020-04-14 15:23
 **/
public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(null);
        set.add(2);
        set.add(2);   //set不可以存放重复元素，如果重复，只保留一个
        System.out.println(set);
        System.out.println(set.contains(5));

        set.remove(2);
        System.out.println("删除之后："+set);
        System.out.println("=========");
        //迭代器
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
