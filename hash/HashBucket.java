package com.src;

/**
 * @program:practice
 * @description：哈希表
 * @Author:xiameng
 * @create:2020-04-12 10:48
 **/
public class HashBucket {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node[] array;//单链表的头结点的引用
    public int usedSize;//记录当前已经存放了多少个数据了   负载因子：哈希表的个数/哈希表的长度

    public HashBucket() {
        this.array = new Node[8];
        this.usedSize = 0;
    }

    //put方法
    public void put(int key,int value){
        int index = key % this.array.length;//下标
        //遍历index下标的单链表，看是否存在数据key
        for (Node cur = array[index];cur!=null  ; cur = cur.next) {
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        Node node = new Node(key,value);
        node.next = array[index];
        array[index]= node;
        this.usedSize++;

        if(loadFactor() >= 0.75){
            resize();
        }
    }
    private double loadFactor(){
        return usedSize*1.0/array.length;
    }
    //扩容
    private void resize(){
        Node[] newArray = new Node[array.length*2];
        //遍历原来的数组，把原来的数据重新哈希到新的数组中
        for (int i = 0; i < array.length; i++) {
            Node curNext;
            for(Node cur = array[i];cur!=null  ;cur = curNext){
                curNext = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }


    public int getValue(int key){
        int index = key % array.length;
        for (Node cur = array[index];cur!=null;cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(1,110);
        hashBucket.put(9,990);
        int val = hashBucket.getValue(9);
        System.out.println(val);
    }
}
