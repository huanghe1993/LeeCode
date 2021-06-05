package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串76 {

    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 后面出现的时候计数器是不会进去递增的aaooobc,第二次a的时候不应该递增
                if (map.get(c) > 0) {
                    count++;
                }
                map.put(c, map.get(c) - 1);

            }
            // 取
            while (count == t.length()) {
                if (i - left + 1 < minLength) {
                    minLength = i - left + 1;
                    minStart = left;
                }
                char c1 = s.charAt(left);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    // 因为会出现map.get(c1)为负数的情况
                    if (map.get(c1) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s ="ADOBECODEBANC", t = "ABC";
        String s1 = new 最小覆盖子串76().minWindow(s, t);
        System.out.println(s1);

    }
}
