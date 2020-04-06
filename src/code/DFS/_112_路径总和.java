package code.DFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author River
 * @date 2020/4/5 17:53
 * @description 描述
 */
public class _112_路径总和 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs(root, sum, res);
        return result;
    }


    public void dfs(TreeNode node, int cur, LinkedList<Integer> res) {
        if (node == null) {
            return;
        }

        cur = cur - node.val;
        res.addLast(node.val);

        // 判断边界
        boolean flag = node.left == null && node.right == null;
        if (node.left == null && node.right == null) {
            if (cur == 0) {
                res.forEach(System.out::print);
                // res全局只有一份
                result.add(new ArrayList<>(res));
                System.out.println();
                // 回溯
                res.removeLast();
                return;
            }
        }

        // 递归
        dfs(node.left, cur, res);
        dfs(node.right, cur, res);

        // （回溯）恢复初始状态
        res.removeLast();
    }

}

