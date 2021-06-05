package 滑动窗口;

public class 长度最小的子数组_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                minLength = Math.min(minLength,i-left+1);
                sum -=nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0:minLength;
    }
}
