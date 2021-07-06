package 剑指offer;

import util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class 剑指Offer32_II_从上到下打印二叉树 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));
        while(!queue.isEmpty()){
            List<TreeNode> fonts = queue.poll();
            res.add(fonts.stream().map(treeNode -> treeNode.val).collect(Collectors.toList()));
            List<TreeNode> lists = new ArrayList<>();
            for (TreeNode node:fonts){
                if(node.left!=null){
                    lists.add(node.left);
                }
                if (node.right != null) {
                    lists.add(node.right);
                }
            }
            if (lists.size() == 0){
                queue.add(lists);
            }
        }
        return res;
    }
}
