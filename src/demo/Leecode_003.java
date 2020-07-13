package demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author River
 * @date 2020/7/4 22:30
 * @description
 */
public class Leecode_003 {


    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i,j)) {
                    result = Math.max(j - i, result);
                }
            }
        }
        return result;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        if (null == s) {
            return result;
        }
        int start = 0, end = 0;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        while (end < len){
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            }else {
                set.remove(s.charAt(start++));
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        if (null == s) {
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start=0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            } else {
                //记录子字符串的最大的长度
                result = Math.max(result, end - start + 1);
                //map记录第一次遍历到key时的索引位置，j+1,保证i跳到不包含重复字母的位置
                map.put(s.charAt(end), end + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = new Leecode_003().lengthOfLongestSubstring2(s);
        System.out.println(i);
    }

}
