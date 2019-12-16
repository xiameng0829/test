package oj;

/**
 * @program:class
 * @description:编写一个程序，找到两个单链表相交的起始节点。
 * @Author:xiameng
 * @create:2019-12-15 09:08
 **/
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        int countA=0;
        int countB=0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!=null){
            countA++;
            pA=pA.next;
        }
        while (pB!=null){
            countB++;
            pB=pB.next;
        }
        while (countA>countB){
            countA--;
            headA=headA.next;
        }
        while (countA<countB){
            countB--;
            headB=headB.next;
        }
        while (headA!=null){
            if(headA == headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;

        /*
        if(headA==null || headB==null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!=pB){
            //此时还没有相交
            pA = (pA==null) ? headB:pA.next;
            pB = (pB==null) ? headA:pB.next;
        }
        return pA;
        */
    }
}
