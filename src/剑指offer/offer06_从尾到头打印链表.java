package 剑指offer;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class offer06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();
        ListNode cur = head;
        while (null != cur) {
            int value = cur.val;
            queue.addFirst(value);
            cur = cur.next;
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();
    }
}
