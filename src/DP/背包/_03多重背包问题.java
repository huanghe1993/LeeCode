package DP.背包;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author River
 * @date 2020/7/19 8:50
 * @description 有 N 种物品和一个容量是 V 的背包。
 * <p>
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 * <p>
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 */
public class _03多重背包问题 {


    /**
     * 拆成01背包来做，按二进制去拆
     * 第i个物品最多选s个， 可以表示为 i个物品选1个、2个、4个、8个、16个直到小于s的2的幂次
     * 基于这种思想去把多件物品转换为，多种一件物品
     * 由此转换成0 1背包问题。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 物品个数
        int N = sc.nextInt();
        // 背包容量
        int V = sc.nextInt();
        ArrayList<Integer> v = new ArrayList<Integer>();
        ArrayList<Integer> w = new ArrayList<Integer>();
        // 每个商品拆成多个单个的物品，然后扔进一个大的价值池中和重量池中，装换成一个01背包问题
        // 分别构造价值和重量的列表，然后就是01背包问题求解
        for (int i = 0; i < N; i++) {
            // 体积vi
            int vi = sc.nextInt();
            // 价值wi
            int wi = sc.nextInt();
            // 个数si
            int si = sc.nextInt();
            for (int j = 1; j < si; j *= 2) {
                si = si - j;
                v.add(vi * j);
                w.add(wi * j);
            }
            if (si > 0) {
                v.add(vi * si);
                w.add(wi * si);
            }
        }
        int[] dp = new int[V + 1];
        for (int i = 0; i < v.size(); i++) {
            for (int j = V; j >= v.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
            }
        }
        System.out.println(dp[V]);
    }

    public static int solution1(int N) {
        Scanner sc = new Scanner(System.in);
        // 物品个数
        int n = sc.nextInt();
        // 背包容量
        int v = sc.nextInt();
        //  定义数组
        int[] dp = new int[N];
        int[] V = new int[N];
        int[] W = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
            W[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }

        // 物品个数
        for (int i = 1; i <= n; i++) {
            // 数量
            for (int j = 1; j < S[i]; j++) {
                // 倒遍历
                for (int k = v; k >= V[i]; k--) {
                    // 第二个dp[k]是i-1状态的
                    dp[k] = Math.max(dp[k], dp[k - V[i]] + W[i]);
                }
            }
        }
        System.out.println(dp[v]);
        return dp[v];
    }
}
