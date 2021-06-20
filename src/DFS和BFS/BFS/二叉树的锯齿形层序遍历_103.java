package DFS和BFS.BFS;

import util.TreeNode;

import java.util.*;

public class 二叉树的锯齿形层序遍历_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(Collections.singletonList(root));
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<TreeNode> fonts = queue.poll();
            List<Integer> list = convertTop(fonts);
            if (flag){
                Collections.reverse(list);
            }
            result.add(list);
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : fonts) {
                if (null != node.left) {
                    temp.add(node.left);
                }
                if (null != node.right) {
                    temp.add(node.right);
                }
            }
            if (temp.size() != 0) {
                queue.offer(temp);
            }
            flag = !flag;
        }
        return result;
    }


    private List<Integer> convertTop(List<TreeNode> fonts) {
        ArrayList<Integer> list = new ArrayList<>();
        for (TreeNode node : fonts) {
            list.add(node.val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode_1 = new TreeNode(-1);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode0.left = treeNode2;
        treeNode0.right = treeNode4;
        treeNode2.left = treeNode1;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode_1;
        treeNode1.left = treeNode5;
        treeNode1.right = treeNode11;
        treeNode3.right = treeNode6;
        treeNode_1.right = treeNode8;
        List<List<Integer>> lists = new 二叉树的锯齿形层序遍历_103().zigzagLevelOrder(treeNode0);
        System.out.println(lists);
    }
}
