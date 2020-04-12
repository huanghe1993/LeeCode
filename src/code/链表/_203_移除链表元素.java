package code.链表;

import util.ListNode;

/**
 * @author River
 * @date 2020/4/12 18:54
 * @description
 */
public class _203_移除链表元素 {

        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            // 特殊的处理 [1,1,1]  1
            while(head!=null && head.val==val){
                head = head.next;
            }
            // 一般情况
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }
            return head;

        }

}
