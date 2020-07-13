package String;

import java.util.Stack;

/**
 * @author River
 * @date 2020/7/14 7:40
 * @description : 掘金上的字节的面试题目：给定一个只包含‘（’和‘）’的字符串，判断字符串是否有效，注：空字符串属于有效的字符串
 */
public class ValidString2 {

    public static boolean validString(String s) {
        if (null == s || s.length() < 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 由于在栈中都是存的是同样的一个字符，所以没有必要开辟一个栈空间存储,使用一个计数器进行加减
     * @param s
     * @return
     */
    public static boolean validString2(String s) {
        if (null == s || s.length() < 1) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }

}
