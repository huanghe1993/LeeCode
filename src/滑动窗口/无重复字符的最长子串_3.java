package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串_3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (map.containsKey(c) && map.get(c) > 0) {
                Character leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            map.put(c, 1);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 模板代码第一步：放，把当前的元素放入的窗口中
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 模板代码第二步：出，当窗口不满足条件的时候就需要left不断的退出窗口
            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(c, map.get(c) - 1);
                // 出的时候需要移动左指针
                left++;
            }
            // 模板代码第三步：计算满足当前窗口的值
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ab";
        int max = new 无重复字符的最长子串_3().lengthOfLongestSubstring(s);
        System.out.println(max);

    }
}
