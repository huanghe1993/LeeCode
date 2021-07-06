package 位运算;

public class Leetcode_260_只出现一次的个数 {

    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        ans &= -ans;
        // 取最后的一位1，最后的1位1表示的是两者都不可能是相等的
        int[] res2 = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & ans) == 0) {
                res2[1] ^= nums[i];
            }else {
                res2[0]^=nums[i];
            }
        }
        return res2;

    }
}
