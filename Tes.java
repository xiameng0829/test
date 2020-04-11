package com.src;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program:practice
 * @description
 * list当中存放的数据为10万个，找出第一个重复的数据
 * @Author:xiameng
 * @create:2020-04-11 15:22
 **/
public class Tes {
    public static void main1(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i < 100000; i++) {
            arrayList.add(random.nextInt(600000));
        }
        Set<Integer> set = new HashSet<>();

        //list当中存放的数据为10万个，找出第一个重复的数据
        /*
        for (Integer val:arrayList) {
            if(set.contains(val)){
                System.out.println(val);
                return;
            }else{
                set.add(val);
            }
        }
        */


        //把重复的数字都去重
        for (Integer val:arrayList) {
            set.add(val);

        }
        System.out.println(set);
    }


    //将十万个数据，统计重复数字及出现的次数
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i < 100000; i++) {
            arrayList.add(random.nextInt(600000));
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer key: arrayList) {
            if(map.get(key)==null){
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println("重复的数字："+entry.getKey()+"  重复的次数"+entry.getValue());
        }
    }
}
