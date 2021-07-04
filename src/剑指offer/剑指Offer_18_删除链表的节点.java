package 剑指offer;

import util.ListNode;

public class 剑指Offer_18_删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        if(cur.val == val){
            return cur.next;
        }
        while (cur.next !=null && cur.next.val != val) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {

    }

}
