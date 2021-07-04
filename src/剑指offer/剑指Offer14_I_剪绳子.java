package 剑指offer;

public class 剑指Offer14_I_剪绳子 {

    /**
     * 减绳子是动态规划的问题
     *
     * @param n 绳子的长度
     * @return 最大的乘积
     * 当绳子的长度为i的时候，可以把绳子减为{1,i-1} ,也可以把绳子减为{2 ,i-2} ....
     * 其中i-1可以取最优解dp[i-1]
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = i - 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i - j] * j, dp[i]);
                dp[i] = Math.max((i - j) * j, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        剑指Offer14_I_剪绳子 obj = new 剑指Offer14_I_剪绳子();
        int i = obj.cuttingRope(2);
        System.out.println(i);
    }

}
