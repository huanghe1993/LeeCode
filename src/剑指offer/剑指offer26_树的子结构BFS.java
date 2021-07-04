package 剑指offer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 剑指offer26_树的子结构BFS {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == B.val) {
                if (helper(node, B)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean helper(TreeNode nodeA, TreeNode nodeB) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.offer(nodeA);
        queueB.offer(nodeB);

        while (!queueB.isEmpty()) {
            nodeA = queueA.poll();
            nodeB = queueB.poll();
            if (nodeA == null || nodeA.val != nodeB.val) {
                return false;
            }
            if (nodeB.left != null) {
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.left);
            }
            if (nodeB.right != null) {
                queueA.offer(nodeA.right);
                queueB.offer(nodeB.right);
            }
        }
        return true;
    }

}
