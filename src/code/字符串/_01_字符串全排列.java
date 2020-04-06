package code.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author River
 * @date 2020/4/5 11:09
 * @description
 */
public class _01_字符串全排列 {

    List<List<Integer>> res = new ArrayList<>();


    public void perm(int[] A, int p, int q) {
        if (p == q) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= q; j++) {
                list.add(A[j]);
            }
            res.add(list);
            return;
        }
        for (int i = p; i < q + 1; i++) {
            // 把数组中的每个元素都和第1个元素交换
            swap(A, p, i);
            // 剩下的元素做全排列
            perm(A, p + 1, q);
            // 把数组中的元素交换过来
            swap(A, p, i);
        }
    }


    /**
     * dfs进行字符串的全排列:['A','B','C'],[false,false,false], deepth =1
     *
     * @param array  字符串数组
     * @param record 记录字符串中的字母是否被访问到
     */
    public static void dfs(char[] array, boolean[] record, int deepth, LinkedList<Character> res) {
        // 记录答案与控制递归深度
        if (deepth == array.length + 1) {
            res.forEach(System.out::print);
            System.out.println();
            return;
        }

        // 遍历候选节点
        for (int i = 0; i < array.length; i++) {
            // 下面的这一段的判断是，判断候选节点是否作为候选
            boolean flag = record[i];
            char c = array[i];
            if (flag) {
                continue;
            }
            // 未被使用，则加入到结果中
            res.addLast(c);
            // 把这个元素置为true，这样下一个元素方便是使用过的
            record[i] = true;

            // 递归:继续向下遍历
            dfs(array, record, deepth + 1, res);

            // 回溯:复原原始的状态
            res.removeLast();
            record[i] = false;
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 3};
        //new _01_字符串全排列().perm(input, 0, 2);
        LinkedList<Character> result = new LinkedList<>();
        char[] input = {'A','B','C'};
        boolean[] record = {false, false, false};
        dfs(input, record, 1, result);
    }
}
