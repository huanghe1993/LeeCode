package code;

import sun.security.x509.OtherName;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author huanghe
 * @Date 2020/1/11 22:05
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Num0001 {

    public static void main(String[] args) {
        int[] nums = {2, 7,  11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(twoSum2(nums, target)));

    }


    /**
     * 方法：暴力求解，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];
        if (nums.length == 0) {
            System.out.println("没有返回值");
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 9) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                }
            }
        }
        return resultArray;
    }

    /**
     * 方法二：使用map的方式，空间换时间，把每次的循环的值记录下来
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] resultArray = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int otherNum = target - nums[index];
            if (map.containsKey(otherNum)) {
                return new int[]{map.get(otherNum),index};
            }
            map.put(nums[index], index);
        }
        return null;

    }

}
