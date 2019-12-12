package oj;

/**
 * @program:class
 * @description:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @Author:xiameng
 * @create:2019-12-10 20:47
 **/
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        /*
        if(head==null || head.next==null){
            return head;
        }
        if(head.val == head.next.val){
            head.next=head.next.next;
            deleteDuplicates(head);
        }else {
            deleteDuplicates(head.next);
        }
        return head;
        */
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;
        ListNode temp=dummyHead;
        while (temp.next!=null){
            if(temp.val == temp.next.val){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return dummyHead.next;
    }
}
