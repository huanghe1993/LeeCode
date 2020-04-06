package code.DFS;

import util.TreeNode;

/**
 * @author River
 * @date 2020/4/6 18:21
 * @description
 */
public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        boolean dfs = dfs(root, root);
        return dfs;
    }

    private boolean dfs(TreeNode node1,TreeNode node2) {
        if (node1 == null && node2 ==null) {
            return true;
        }

        if ((node1 ==null && node2!=null) || (node1 !=null && node2 ==null) || (node1.val != node2.val) ) {
            return false;
        }

        if ( !dfs(node1.left, node2.right)){
            return false;
        }

        if ( !dfs(node1.right, node2.left)){
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2L = new TreeNode(2);
        TreeNode treeNode2R = new TreeNode(2);
        TreeNode treeNode3L = new TreeNode(3);
        TreeNode treeNode3R = new TreeNode(3);
        TreeNode treeNode4L = new TreeNode(4);
        TreeNode treeNode4R = new TreeNode(4);

        treeNode1.left = treeNode2L;
        treeNode1.right = treeNode2R;

        //treeNode2L.left = treeNode3L;
        treeNode2L.right = treeNode3R;

        //treeNode2R.left = treeNode4L;
        treeNode2R.right = treeNode3R;


        boolean validBST = new _101_对称二叉树().isSymmetric(treeNode1);
        System.out.println(validBST);
    }


}
