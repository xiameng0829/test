package com.src;

import java.util.HashMap;
import java.util.Objects;

/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-04-12 11:45
 **/

/**
 * 重写equals和hashcode，保证数据的一致性
 */
class Person{
    public int id;

    public Person(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
public class HashBucket2<K,V> {
    static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key,V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array;//单链表的头结点的引用
    public int usedSize;//记录当前已经存放了多少个数据了   负载因子：哈希表的个数/哈希表的长度

    public HashBucket2() {
        this.array = (Node<K,V>[])new Node[8];
        this.usedSize = 0;
    }


    public void put(K key,V value){
        int hash = key.hashCode();
        int index = hash % this.array.length;
        for (Node cur = array[index];cur!=null  ; cur = cur.next) {
            if(cur.key.equals(key)){
                cur.val = value;
                return;
            }
        }
        Node<K,V> node = new Node<>(key,value);
        node.next = array[index];
        array[index]= node;
        this.usedSize++;
    }


    public V getValue(K key){
        int hash = key.hashCode();
        int index = hash % this.array.length;
        for (Node<K,V> cur = array[index];cur!=null;cur = cur.next){
            if(cur.key.equals(key)){
                return cur.val;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Person person1 = new Person((20200414));
        Person person2 = new Person((20200414));
        HashBucket2<Person,String> hashBucket2 = new HashBucket2<>();
        hashBucket2.put(person1,"hello");
        System.out.println(hashBucket2.getValue(person2));

        System.out.println("=====");
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(2,2);
        System.out.println(hashMap);
    }

}
