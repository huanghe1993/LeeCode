package code.链表;

import util.ListNode;

/**
 * @author River
 * @date 2020/4/12 10:35
 * @description
 */
public class _206_反转单链表 {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode  pHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = pHead;
            pHead = temp;
        }

        return pHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
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
}
