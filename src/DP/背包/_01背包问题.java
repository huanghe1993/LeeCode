package DP.背包;

/**
 * @author River
 * @date 2020/7/18 19:01
 * @description
 */
public class _01背包问题 {

    public static void main(String[] args) {
        // 重量
        int[] weigth = {0, 2, 3, 4, 5, 9};
        // 价值
        int[] value = {0, 3, 4, 5, 8, 10};
        int N = 6;
        int W = 21;
        int knapstack = knapstack(weigth, value, N, W);
        System.out.println(knapstack);
    }


    /**
     * @param weight
     * @param value
     * @param N      总共N件物品
     * @param W      背包的总容量W
     * @return
     */
    public static int knapstack(int[] weight, int[] value, int N, int W) {
        int[][] dp = new int[N][W];
        // k 表示的是第k件物品
        for (int k = 1; k < N; k++) {
            // c 表示的是背包的容量
            for (int c = 1; c < W; c++) {
                // 当物品的体积大于背包剩下容量
                if (weight[k] > c) {
                    dp[k][c] = dp[k - 1][c];
                } else {
                    // 偷第k件物品
                    int value1 = dp[k - 1][c - weight[k]] + value[k];
                    // 不偷第K件物品
                    int value2 = dp[k - 1][c];
                    dp[k][c] = Math.max(value1, value1);
                }
            }
        }
        return dp[5][20];

    }
}
