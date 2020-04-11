package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:practice
 * @description：复制带随机指针的链表
 * @Author:xiameng
 * @create:2020-04-11 16:54
 **/
class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution138 {
    public Node2 copyRandomList(Node2 head) {
        Map<Node2,Node2> map = new HashMap<>();
        Node2 cur = head;

        while(cur != null) {
            Node2 node = new Node2(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;

        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
