package oj;

/**
 * @program:class
 * @description:给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。给定的 n 保证是有效的。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Author:xiameng
 * @create:2019-12-12 21:00
 **/
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        int count=0;
        ListNode fast=head;
        ListNode second=head;
        while (fast!=null){
            fast=fast.next;
            count++;
            if(count>=n+2){
                second=second.next;
            }
        }
        //此时处在待删除位置的前一个结点
        if(count==n){
            return head.next;
        }else {
            second.next=second.next.next;
            return head;
        }
    }
}
