package code.链表;

import util.ListNode;

/**
 * @author River
 * @date 2020/4/12 9:54
 * @description
 */
public class _001_创建链表_demo {

    /**
     * 添加元素到指定的位置
     * @param node 结点
     * @param phead 头结点
     * @param location 指定的位置
     * @return 头结点
     */
    public ListNode addNodeToLocation(ListNode node, ListNode phead, int location) {
        // 获取链表的长度
        ListNode cur = phead;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        if (location > count || location < 0) {
            System.out.println("插入的位置不在链表的范围内");
            return null;
        }
        ListNode temp = phead;
        // phead -> 2 -> 4 -> 3
        for (int i = 0; i < location; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        return phead;

    }

    /**
     * 添加结点到最后
     * @return
     */
    public ListNode createSingleLink(ListNode node,ListNode phead){
        if (phead.next == null) {
            phead.next = node;
            return phead;
        }
        ListNode cur = phead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return phead;
    }

    /**
     * 打印链表
     * @param head
     */
    public void printLink(ListNode head){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur.val);
        }
    }




    public static void main(String[] args) {
        _001_创建链表_demo demo = new _001_创建链表_demo();
        // 创建头结点
        ListNode phead = new ListNode(-1);
        // 第一个结点
        ListNode firstNode = new ListNode(2);
        phead.next = firstNode;
        // 第二个结点
        ListNode secondNode = new ListNode(4);
        firstNode.next = secondNode;

        ListNode pHead1 =demo.createSingleLink(new ListNode(3), phead);

        ListNode pHead2 = demo.addNodeToLocation(new ListNode(5), phead, 2);

        demo.printLink(pHead2);

    }

}
