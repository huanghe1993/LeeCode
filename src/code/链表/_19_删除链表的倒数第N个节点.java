package code.链表;

import util.ListNode;

import java.util.List;

/**
 * @author River
 * @date 2020/4/12 18:32
 * @description
 */
public class _19_删除链表的倒数第N个节点 {

    // 1->2->3->4->5, 和 n = 2.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new _19_删除链表的倒数第N个节点().removeNthFromEnd(node1, 2);
    }
}
