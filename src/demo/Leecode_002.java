package demo;

import util.ListNode;

import java.util.List;

/**
 * @author River
 * @date 2020/7/4 22:13
 * @description
 */
public class Leecode_002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder != 0) {
            ListNode node = new ListNode(0);
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            node.val = (v1 + v2 + remainder) % 10;
            remainder = (v1 + v2 + remainder) / 10;
            current.next = node;
            current = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        ListNode node = new Leecode_002().addTwoNumbers(node1, node4);

        System.out.println(node.val);

        System.out.println(node.next.val);

        System.out.println(node.next.next.val);
    }

}


