package DFS和BFS.BFS;

import util.TreeNode;

import java.util.*;

public class 二叉树的层序遍历_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(Collections.singletonList(root));
        while (!queue.isEmpty()) {
            List<TreeNode> fonts = queue.poll();
            result.add(convertTop(fonts));
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
        }
        return result;
    }

    private List<Integer> convertTop(List<TreeNode> fonts){
        ArrayList<Integer> list = new ArrayList<>();
        for (TreeNode node : fonts) {
            list.add(node.val);
        }
        return list;
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
        List<List<Integer>> lists = new 二叉树的层序遍历_102().levelOrder(treeNode3);
        System.out.println(lists);
    }
}
