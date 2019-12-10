package oj;

/**
 * @program:class
 * @description:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author:xiameng
 * @create:2019-12-10 18:40
 **/

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
    }
}
