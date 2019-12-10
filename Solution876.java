package oj;

/**
 * @program:class
 * @description:
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * @Author:xiameng
 * @create:2019-12-10 19:24
 **/
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        /*
        //第一次遍历取得当前结点个数
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        //第二次遍历，走n/2
        temp=head;
        for(int i=0;i<n/2;i++){
            temp=temp.next;
        }
        return temp;
        */


        if(head==null | head.next==null){
            return head;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            low = low.next;
            fast = fast.next.next;
        }
        //此时low一定在中间位置
        return low;
    }
}
