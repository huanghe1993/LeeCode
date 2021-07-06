package 剑指offer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指Offer_32从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode font = queue.poll();
            res.add(font.val);
            if(font.left!=null){
                queue.add(font.left);
            }
            if (font.right != null) {
                queue.add(font.right);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
