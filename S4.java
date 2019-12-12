package oj;

/**
 * @program:class
 * @description:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Author:xiameng
 * @create:2019-12-10 20:43
 **/
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class S4 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null || k<=0){
            return null;
        }
        ListNode low=head;
        ListNode fast=head;
        //记录fast所走的步数
        int count=0;
        while (fast!=null){
            fast=fast.next;
            count++;
            if(count>=k+1){
                low=low.next;
            }
        }
        if(k>count){
            return null;
        }
        return low;
    }
}
