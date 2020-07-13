package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author River
 * @date 2020/7/14 7:18
 * @description 给定一个只包括[]和{}的字符串，判断字符串是否有效
 *  例如：{[123]} 属于有效的字符串，[{abc]} 属于无效的字符串
 *  类似的题目：https://www.cnblogs.com/wadmwz/p/11731700.html
 */
public class ValidString {

    public static void main(String[] args) {
        String str1 = "{[123]}";
        String str2 = "[{abc]}";
        boolean valid = isValid(str2);
        System.out.println(valid);
    }


    /**
     * 时间复杂度O（n），空间复杂度 O(n)
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ']' || c == '}'){
                Character top = stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
