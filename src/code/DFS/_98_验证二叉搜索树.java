package code.DFS;

import util.TreeNode;

/**
 * @author River
 * @date 2020/4/6 12:40
 * @description
 */
public class _98_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return res;
    }


    private boolean dfs(TreeNode node, long lower, long upper) {

        if (node == null) {
            return true;
        }

        if (node.val <= lower){
            return false;
        }

        if (node.val >= upper) {
            return false;
        }
        //
        if (!dfs(node.left,lower,node.val)) {
            return false;
        }
        // 右子树的下界就是，上一个节点的值
        if (!dfs(node.right, node.val, upper)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode5.left = treeNode1;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode4;
        treeNode6.right = treeNode7;

        boolean validBST = new _98_验证二叉搜索树().isValidBST(treeNode5);
        System.out.println(validBST);
    }


}
