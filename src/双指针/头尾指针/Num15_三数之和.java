package 双指针.头尾指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author River
 * @date 2020/9/26 15:29
 * @description
 */
public class Num15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int target = leftNum + rightNum;
                // 相等
                if (target == num * -1) {
                    List<Integer> list = Arrays.asList(num, leftNum, rightNum);
                    res.add(list);
                    left++;
                    right--;
                }
                // 目标值小，指针左移
                if (target < num * -1) {
                    left++;
                }
                // 目标值大，右边移动
                if (target > num * -1) {
                    right--;
                }
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> lists = new Num15_三数之和().threeSum(nums);
        List<List<Integer>> collect = lists.stream().distinct().collect(Collectors.toList());


        System.out.println(collect);
    }
}
