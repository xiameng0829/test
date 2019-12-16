package oj;

/**
 * @program:class
 * @description:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 让快慢指针一个走一步一个走两步，当第一次相遇时说明带环，此时相遇位置记为相遇点
 * 让快指针返回头结点，
 * @Author:xiameng
 * @create:2019-12-15 11:54
 **/
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            low=low.next;
            fast=fast.next.next;
            if(low == fast){
                break;  //相遇
            }
        }
        fast=head;
        while (low!=null && low!=fast){
            low=low.next;
            fast=fast.next;
        }
        return low;
    }
}
