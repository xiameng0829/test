package oj;

/**
 * @program:class
 * @description:
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author:xiameng
 * @create:2019-12-10 20:44
 **/
public class S7 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode temp=head;
        while (head.next!=null){
            if(head.next!=null && head.next.val==head.val){
                while (head.next!=null && head.next.val==head.val){
                    head.next=head.next.next;
                }
                head.next=head.next.next;
                head.next=head.next;
            }else {
                head=head.next;
                head.next=head.next.next;
            }
        }
        return head.next;
    }
}
