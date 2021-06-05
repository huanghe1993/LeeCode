package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最长的子串最多包含k个字符_340 {

    public int lengthOfLongestSubstringTKistinct(String s, int k) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char c1 = s.charAt(left);
                if (0 == map.get(c1)) {
                    map.remove(c1);
                }
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
