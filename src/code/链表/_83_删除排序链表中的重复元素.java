package code.链表;

import util.ListNode;

import java.util.ArrayList;

/**
 * @author River
 * @date 2020/4/12 17:31
 * @description
 */
public class _83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null) {
            return null;
        }

        ListNode pHead = new ListNode(-1);
        ListNode cur = pHead;
        while (head != null) {
            if (list.contains(head.val)) {
                head = head.next;
                continue;
            }
            ListNode listNode = new ListNode(head.val);
            list.add(head.val);
            cur.next = listNode;
            cur = cur.next;
            head = head.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode11 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode11;
        listNode11.next = listNode2;

        new _83_删除排序链表中的重复元素().deleteDuplicates(listNode1);
    }
}
