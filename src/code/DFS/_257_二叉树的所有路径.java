package code.DFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author River
 * @date 2020/4/6 10:39
 * @description
 */
public class _257_二叉树的所有路径 {

    List<String> result = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        LinkedList<String> list = new LinkedList<>();
        dfs(root, list);
        return result;

    }

    public void dfs(TreeNode node, LinkedList<String> res) {

        if (node == null) {
            return;
        }

        res.addLast(String.valueOf(node.val));
        // 退出条件
        if (node.left == null && node.right == null) {
            String resStr = String.join("->", res);
            result.add(resStr);
            res.removeLast();
            return;
        }

        // 递归
        dfs(node.left, res);
        dfs(node.right, res);

        // 回溯
        res.removeLast();

    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_ = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_ = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_;
        treeNode4_.left = treeNode5_;
        treeNode4_.right = treeNode1;

        _257_二叉树的所有路径 solution = new _257_二叉树的所有路径();
        List<String> res = solution.binaryTreePaths(treeNode5);
        System.out.println(res);

    }

}
