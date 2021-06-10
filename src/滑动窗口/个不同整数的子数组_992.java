package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 个不同整数的子数组_992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    /**
     * 子数组的不重复的元素的个数最多为 K 个
     */
    public int atMostK(int[] nums, int k) {
        int left = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) == 0) {
                k--;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k < 0) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            result += i - left + 1;
        }
        return result;
    }

}
