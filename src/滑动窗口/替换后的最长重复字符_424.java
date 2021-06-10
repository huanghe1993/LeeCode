package 滑动窗口;

import java.util.Arrays;

public class 替换后的最长重复字符_424 {

    /**
     * 替换后的最长的子串
     * @param s 原始的字符串 "ABBBAC"
     * @param k 最多替换的字符 2
     * @return  替换后的最长重复字符
     */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int result = Integer.MIN_VALUE;
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 字符所在位置的索引进行递增，滑动窗口模板的第一步，进
            charArray[c - 'A']++;
            // 滑动窗口的第二步就是出，当滑动窗口的长度 - 所有字符的最长的长度 > k 的时候是需要进行出
            while (i - left + 1 - findMax(charArray) > k) {
                charArray[s.charAt(left) - 'A']--;
                left++;
            }
            // 计算
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

    private int findMax(int[] charArray) {
        return Arrays.stream(charArray).max().getAsInt();
    }

}
