package code;

/**
 * @Author huanghe
 * @Date 2020/1/11 22:42
 * @Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) +
 *      (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Num002 {

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

        ListNode node = addTwoNumbers(node1, node4);

        System.out.println(node.val);

        System.out.println(node.next.val);

        System.out.println(node.next.next.val);
    }

    /**
     * @param l1 链表1
     * @param l2 链表2
     * @return 两数和
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode index = root;
        int remainder = 0;

        while (l1 != null || l2 != null || remainder != 0) {
            ListNode node = new ListNode(0);
            if (l1 == null || l2 == null){
                l1.val = 0;
                l2.val = 0;
            }
            int temp = remainder == 0 ? l1.val + l2.val : l1.val + l2.val + remainder;
            node.val = temp % 10;
            index.next = node;
            index = node;
            remainder = temp / 10;

            l1 = l1.next;
            l2 = l2.next;
        }
        return root.next;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
