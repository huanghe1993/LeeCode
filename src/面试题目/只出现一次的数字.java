package 面试题目;

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int i = new 只出现一次的数字().singleNumber(nums);
        System.out.println(i);
    }

}
