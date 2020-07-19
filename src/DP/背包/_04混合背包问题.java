package DP.背包;

import java.util.Scanner;

/**
 * @author River
 * @date 2020/7/19 21:05
 * @description 有 N 种物品和一个容量是 V 的背包。
 * 物品一共有三类：
 * <p>
 * 第一类物品只能用1次（01背包）；
 * 第二类物品可以用无限次（完全背包）；
 * 第三类物品最多只能用 si 次（多重背包）；
 * 每种体积是 vi，价值是 wi。
 * <p>
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 * <p>
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 * <p>
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 * <p>
 * si=−1 表示第 i 种物品只能用1次；
 * si=0 表示第 i 种物品可以用无限次；
 * si>0 表示第 i 种物品可以使用 si 次；
 * 输出格式
 * 输出一个整数，表示最大价值。
 */
public class _04混合背包问题 {

    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        // 物品个数
        int N = sc.nextInt();
        // 背包总容量
        int V = sc.nextInt();
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            int v = sc.nextInt(); // 体积
            int w = sc.nextInt(); // 价值
            int s = sc.nextInt(); // 数量
            if (s == 0) {
                // 完全背包问题
                for (int j = v; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            }
            if (s == -1) {
                // 0-1背包
                s = 1;
            }
            // 多重背包代码（0-1背包是多重背包特例）
            for (int k = 1; k <= s; k = k * 2) {
                for (int j = V; j >= k * v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * v] + k * w);
                }
                s = s - k;
            }
            if (s > 0) {
                for (int j = V; j >= s * v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - s * v] + s * w);
                }
            }
        }
        System.out.println(dp[V]);
    }


    public static void solution(String[] args) {
        int N = sc.nextInt(); // 物品个数
        int V = sc.nextInt(); // 背包总容量
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            int v = sc.nextInt(); // 体积
            int w = sc.nextInt(); // 价值
            int s = sc.nextInt(); // 数量
            if (s == 0) {
                // 完全背包问题
                for (int j = v; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            } else {
                // 多重背包问题，01背包是多重背包的特例，可以一并处理
                s = Math.abs(s);
                for (int j = 1; s >= j; s -= j, j *= 2) {
                    for (int k = V; k >= j * v; k--) {
                        dp[k] = Math.max(dp[k], dp[k - j * v] + j * w);
                    }
                }
                if (s > 0) {
                    for (int j = V; j >= s * v; j--) {
                        dp[j] = Math.max(dp[j], dp[j - s * v] + s * w);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

}
