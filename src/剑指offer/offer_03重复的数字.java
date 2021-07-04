package 剑指offer;

import java.util.HashMap;

public class offer_03重复的数字 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count > 1) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }
}
