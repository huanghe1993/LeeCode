package DP.单序列DP;

import java.util.Arrays;

public class 经典题目_最大子序列和_53 {

    /**
     * nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 在看到题目寻找最大，子序列的时候，可以考虑两种解法，第一种是当为子序列的时候本身的反应应该是滑动窗口
     * 当看到最大值的和得时候，这个时候应该想到几种常见的算法，例如栈，动态规划
     * 本题使用的是动态规划的思想来解，从题目上看应该是比较简单的一维动态规划。其状态转移方程为：
     * dp[i] = dp[i-1] if nums[i]< 0
     * dp[i] = dp[i-1] + nums[i] if nums[i]>=0
     *
     * dp[i] = nums[i] + max(dp[i-1],0)
     *
     * @param nums 输入原始数组
     * @return 返回值
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-1],0);
        }
        int max = Arrays.stream(dp).max().getAsInt();
        return max;
    }

    public static void main(String[] args) {
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        int i = new 经典题目_最大子序列和_53().maxSubArray(nums);
        System.out.println(i);


    }
}
