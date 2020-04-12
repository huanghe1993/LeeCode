package code.链表;

import util.ListNode;

import java.util.List;

/**
 * @author River
 * @date 2020/4/12 18:15
 * @description [1,2,3,4,5]
 *
 * [1,2,3,4,5,6]
 */
public class _876_链表的中间结点 {


    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
