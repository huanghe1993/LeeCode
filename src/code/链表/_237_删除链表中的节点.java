package code.链表;

import util.ListNode;

/**
 * @author River
 * @date 2020/4/12 18:23
 * @description
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
