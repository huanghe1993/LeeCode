package 剑指offer;

import util.ListNode;

public class 剑指Offer24_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode phead = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode nextTemp = cur.next;
            cur.next = phead;
            phead = cur;
            cur = nextTemp;
        }
        return phead;
    }

    public static void main(String[] args) {
//        1->2->3->4->5->NULL
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        剑指Offer24_反转链表 obj = new 剑指Offer24_反转链表();
        ListNode listNode = obj.reverseList(listNode1);
        System.out.println(listNode);
    }
}
