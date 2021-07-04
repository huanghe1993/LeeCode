package 剑指offer;

public class 剑指Offer10_II_青蛙跳台阶问题 {

    public int numWays(int n) {
        if(n == 0) {
            return 1;
        }
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }
}
