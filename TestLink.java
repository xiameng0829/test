package com.src;

/**
 * @program:practice
 * @description
 * @Author:xiameng
 * @create:2020-04-05 10:49
 **/


public class TestLink<T> {
    /**
     * 实例内部类
     */
    class Node {
        public T data;
        public Node next;
        public Node (T data) {
            this.data = data;
        }
        public Node () {

        }
    }

    public Node head;

    public void insertHead(T val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void insertTail(T val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //cur  指向的位置 就是尾巴节点
            cur.next = node;
        }
    }

    /**
     * 合并两个有序列表
     * @param headA
     * @param headB
     * @param <T>
     * @return
     */
    public static<T extends Comparable<T>> TestLink<T>.Node mergeList(TestLink<T>.Node headA,TestLink<T>.Node headB){
        TestLink<T> testLink = new TestLink<>();
        TestLink<T>.Node newHead = testLink.new Node();
        TestLink<T>.Node tmp = newHead;
        while (headA!=null && headB!=null){
            if(headA.data.compareTo(headB.data) < 0){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null){
            tmp.next =headA;
        }
        if(headB != null){
            tmp.next =headB;
        }
        return newHead.next;
    }



    public void show2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }



    public void show() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TestLink<Integer> testLink1 = new TestLink<>();
        testLink1.insertTail(2);
        testLink1.insertTail(4);
        testLink1.insertTail(8);
        testLink1.insertTail(9);
        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.insertTail(1);
        testLink2.insertTail(5);
        testLink2.insertTail(6);
        testLink1.show();
        testLink2.show();
        TestLink<Integer>.Node ret = mergeList(testLink1.head,testLink2.head);
        testLink2.show2(ret);
    }
}