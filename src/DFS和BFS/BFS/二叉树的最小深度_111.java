package DFS和BFS.BFS;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度_111 {
    public int minDepth(TreeNode root) {
        int result = 0;
        if (root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode font = queue.poll();
                if (null != font.left) {
                    queue.add(font.left);
                }
                if (null != font.right) {
                    queue.add(font.right);
                }
                if (font.left == null && font.right == null) {
                    result++;
                    return result;
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        int i = new 二叉树的最小深度_111().minDepth(treeNode3);
        System.out.println(i);
    }
}
