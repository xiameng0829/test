package oj;
/**
 * @program:class
 * @description:
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author:xiameng
 * @create:2019-12-10 19:24
 **/

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        if(l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode newLast = null;
        ListNode newHead = newLast;
        while (l1!=null && l2!=null){

            if(l1.val<=l2.val){
                ListNode node = new ListNode(l1.val);
                if(newHead==null){
                    newLast=newHead=null;
                    l1=l1.next;
                }else {
                    newLast.next=node;
                    newLast = node;
                    l1=l1.next;
                }
            }else{
                ListNode node = new ListNode(l2.val);
                if(newHead==null){
                    newLast=newHead=null;
                    l2=l2.next;
                }else {
                    newLast.next=node;
                    newLast = node;
                    l2=l2.next;
                }
            }
        }
        while (l1!=null){
            ListNode node = new ListNode(l1.val);
            newLast.next=node;
            newLast=node;
            l1=l1.next;
        }
        while (l2!=null){
            ListNode node = new ListNode(l2.val);
            newLast.next=node;
            newLast=node;
            l2=l2.next;
        }
        return  newHead;
        */

        ListNode dummyHead = new ListNode(-1);
        ListNode temp=dummyHead;
        //遍历l1与l2
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                temp=l1;
                l1=l1.next;
            }else {
                temp.next=l2;
                temp=l2;
                l2=l2.next;
            }
        }
        temp.next = (l1 == null) ? l2:l1;
        return dummyHead.next;
    }
}

