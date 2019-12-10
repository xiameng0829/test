package oj;

/**
 * @program:class
 * @description:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author:xiameng
 * @create:2019-12-10 19:34
 **/
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        //判断边界
        if(head==null || head.next==null){
            return head;
        }
        //当前链表不为空，遍历当前链表，产生新节点，头插另一个链表
        ListNode newHead = new ListNode(head.val);
        //遍历原先链表
        while (head.next!=null){
            //产生新节点
            ListNode node = new ListNode(head.next.val);
            //将新节点头插到新链表尾部
            node.next=newHead;
            newHead=node;
            head=head.next;
        }
        return newHead;
    }
}
