package DP.背包;

import java.util.Scanner;

/**
 * @author River
 * @date 2020/7/19 21:21
 * @description
 * 1. 状态定义： 当已经选择1...i 个物品且容量 <=j时的最大价值 f[i][j] -> 优化为f[j]
 * 2. 状态计算： 选择i ，不选i -> 优化为遍历所有可能的体积的最大值
 * 3. f[~] = 0
 */
public class _02完全背包问题 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 物品个数
        int C = sc.nextInt(); // 背包大小
        int w = 0, v = 0;
        int[] dp = new int[C+1];
        for(int i = 0; i < N; i++){
            w = sc.nextInt();
            v = sc.nextInt();
            for(int j = w; j <= C; j++){
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[C]);
    }



}
