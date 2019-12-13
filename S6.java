package oj;

/**
 * @program:class
 * @description：
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 * @Author:xiameng
 * @create:2019-12-12 20:39
 **/
public class S6 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        //小链表的头结点
        ListNode smallHead = new ListNode(-1);
        ListNode sTemp=smallHead;
        //大链表
        ListNode bigHead = new ListNode(-1);
        ListNode bTemp=bigHead;
        //遍历原链表
        while (pHead!=null){
            if(pHead.val<x){
                sTemp.next=pHead;
                sTemp=pHead;
            }else {
                bTemp.next=pHead;
                bTemp=pHead;
            }
            pHead=pHead.next;
        }
        bTemp.next=null;
        sTemp.next = bigHead.next;
        return smallHead.next;
    }
}
