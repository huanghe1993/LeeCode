package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 至少K重复字符最长子串_395 {

    // 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
    // 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
    // 输入：s = "ababbc", k = 2
    // 输出：5
    // 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
    public int longestSubstring(String s, int k) {
        // 总共有26个字符，计算出只有1个到26个字符的时候出现的次数不少于K的最长的子串
        int maxLength = 0;
        for (int i = 1; i < 26; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int vaildCount = 0;
            int left = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) {
                    vaildCount++;
                }
                while (map.keySet().size() > i) {
                    Character leftChar = s.charAt(left);
                    if (map.get(leftChar) == k) {
                        // 有效的字符串减少一个
                        vaildCount--;
                    }
                    // map中的计数器减少一个
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    // 当字符数减少为0，需要把当前的map中的存放的
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    left++;
                }
                // 只有当有效的字符串等于当前需要进行求解的字符串的时候才计算当前字符串的长度
                if (vaildCount == i) {
                    maxLength = Math.max(maxLength, j - left + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aaabb";
        String s2 = "ababbc";
        int k = 3;
        int i = new 至少K重复字符最长子串_395().longestSubstring(s, k);
        int i2 = new 至少K重复字符最长子串_395().longestSubstring(s2, 2);
        System.out.println(i);
        System.out.println(i2);
    }
}
