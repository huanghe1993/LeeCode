package 剑指offer;

import java.util.Arrays;

public class 剑指Offer21_调整数组顺序使奇数位于偶数前面 {

    //  [1,2,3,4]
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length - 1 && nums[left] % 2 != 0) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        剑指Offer21_调整数组顺序使奇数位于偶数前面 obj = new 剑指Offer21_调整数组顺序使奇数位于偶数前面();
        int[] exchange = obj.exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
