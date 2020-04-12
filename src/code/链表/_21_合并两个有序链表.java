package code.链表;

import util.ListNode;

import java.util.List;

/**
 * @author River
 * @date 2020/4/12 18:04
 * @description
 */
public class _21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode phead = new ListNode(-1);
        ListNode cur = phead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return phead;
    }
}
