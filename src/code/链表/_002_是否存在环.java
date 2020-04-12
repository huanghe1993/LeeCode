package code.链表;

import util.ListNode;

/**
 * @author River
 * @date 2020/4/12 17:24
 * @description
 */
public class _002_是否存在环 {

    public boolean isCircle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
