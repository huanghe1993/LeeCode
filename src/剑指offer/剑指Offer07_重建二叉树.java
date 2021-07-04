package 剑指offer;

import util.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 剑指Offer07_重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = dfs(preorder, inorder);
        return root;
    }

    private TreeNode dfs(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        List<Integer> inorders = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootIndex = inorders.indexOf(rootVal);

        int[] inorderLeftArray = new int[rootIndex];
        int[] inorderRightArray = new int[inorder.length - rootIndex - 1];
        System.arraycopy(inorder, 0, inorderLeftArray, 0, rootIndex);
        System.arraycopy(inorder, rootIndex + 1, inorderRightArray, 0, inorder.length - rootIndex - 1);

        int[] preorderLeftArray = new int[rootIndex];
        int[] preorderRightArray = new int[inorder.length - rootIndex - 1];
        System.arraycopy(preorder, 1, preorderLeftArray, 0, rootIndex);
        System.arraycopy(preorder, rootIndex + 1, preorderRightArray, 0, inorder.length - rootIndex - 1);

        root.left = dfs(preorderLeftArray, inorderLeftArray);
        root.right = dfs(preorderRightArray,inorderRightArray);

        return root;

    }

    public static void main(String[] args) {
        剑指Offer07_重建二叉树 obj = new 剑指Offer07_重建二叉树();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = obj.buildTree(preorder, inorder);

    }
}
