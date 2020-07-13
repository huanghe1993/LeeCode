package demo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author River
 * @date 2020/7/4 22:01
 * @description
 */
public class Leecode_001 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length <= 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                Integer index = map.get(key);
                result[0] = i;
                result[1] = index;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new Leecode_001().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
