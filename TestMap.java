package com.src;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:practice
 * @description : Map的常见方法
 * @Author:xiameng
 * @create:2020-04-14 15:01
 **/
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"C++");
        map.put(3,"python");
        map.put(1,"R");  //key值重复，会更新key的值
        map.put(null,null);
        System.out.println(map);
        System.out.println(map.get(1)); //返回key对应的value
        //返回 key 对应的 value，key 不存在，返回默认值
        System.out.println(map.getOrDefault(4,"C"));
        System.out.println("========");
        //删除
        map.remove(3);
        System.out.println("删除之后的集合："+map);

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.containsKey(7)); //判断是否包含key
        System.out.println(map.containsValue("R"));  //判断是否包含value
        System.out.println("========");
        //打印key
        for (Integer key:map.keySet()) {
            System.out.println(key);
        }
        System.out.println("=========");
        //打印value
        for (String value: map.values()) {
            System.out.println(value);
        }

        System.out.println("----------");

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

    }
}
