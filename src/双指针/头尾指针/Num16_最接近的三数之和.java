package 双指针.头尾指针;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author River
 * @date 2020/9/26 16:58
 * @description
 */
public class Num16_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                // 获取到临时的差值
                int tempTarget = target - num;
                // 相等
                if (tempTarget == leftNum + rightNum) {
                    List<Integer> list = Arrays.asList(num, leftNum, rightNum);
                    return 0;
                }
                // 目标值小，指针左移
                if (target < leftNum + rightNum) {
                    res = Math.min(res, tempTarget - (leftNum + rightNum));
                    left++;
                }
                // 目标值大，右边移动
                if (target > leftNum + rightNum) {
                    res = Math.min(res, tempTarget - (leftNum + rightNum));
                    right--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int res = new Num16_最接近的三数之和().threeSumClosest(nums,1);
        System.out.println(res);
    }
}
