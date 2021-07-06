package code.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_3_移除k个元素使得数字最小 {

    /**
     * 移除k个元素使得数字是最小的数字，
     * num = "1432219", k = 3
     * num = "10200", k = 1
     *
     * @param num 初始化数值
     * @param k   k个位置
     * @return 最小的数值
     */
    public String removeKdigits(String num, int k) {
        // 使用的是单调递增栈.但是在弹出栈的时候需要注意的是,最后结果的长度应该是num.length - k.
        char[] chars = num.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            // 时刻需要保证栈中的元素 + 剩下的元素 >= 需要的元素
            // stack.size() + num.length - i >=  num.length - k
            while (!stack.isEmpty() && chars[i] < chars[stack.peek()] & stack.size() + num.length() - i - 1 >= num.length() - k) {
                stack.pop();
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && chars[stack.getLast()] == '0') {
            stack.removeLast();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        int index = 0;
        while (!stack.isEmpty() && index < num.length() - k) {
            sb.append(chars[stack.removeLast()]);
            index++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String num = "10001";
        int k = 4;
        String s = new Leetcode_3_移除k个元素使得数字最小().removeKdigits(num, k);
        System.out.println(s);
    }
}
