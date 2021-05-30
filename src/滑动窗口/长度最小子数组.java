package 滑动窗口;

public class 长度最小子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        // 1:初始化慢指针为0：
        int left = 0;
        int total = 0;
        // 2:初始化ans
        int ans = nums.length +1;
        // 3:循环快指针在可迭代的集合中
        for (int r = 0; r < nums.length; r++) {
            // 判断窗口中的连续的元素是否满足题目的要求,当窗口满足题目的意思
            total = total + nums[r];
            while (total >=target){
                // 扩展或者是收缩窗口，慢指针移动
                ans = Math.min(ans,r-left+1);
                total = total - nums[left];
                left = left +1;
            }
        }
        return ans;
    }
}
