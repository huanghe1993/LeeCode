package code.DFS;

import util.TreeNode;

/**
 * @author River
 * @date 2020/4/6 17:55
 * @description
 */
public class _100_相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }

        return dfs(p, q);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if ((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1.val != node2.val)) {
            return false;
        }

        if(!dfs(node1.left, node2.left)){
            return false;
        }
        if (!dfs(node1.right, node2.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNodep1 = new TreeNode(1);
        TreeNode treeNodep2 = new TreeNode(2);

        TreeNode treeNodeq1 = new TreeNode(1);
        TreeNode treeNodeq2 = new TreeNode(2);

        treeNodep1.left = treeNodep2;

        treeNodeq1.right = treeNodeq2;

        boolean validBST = new _100_相同的树().isSameTree(treeNodep1, treeNodeq1);
        System.out.println(validBST);
    }
}
