package code.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class a_模板代码 {

    /**
     * 题目是这样的，给一个数组，返回一个大小相同的数组。返回的数组的第i个位置的值应当是，对于原数组中的第i个元素，至少往右走多少步，才能遇到一个比自己大的元素（如果之后没有比自己大的元素，或者已经是最后一个元素，则在返回数组的对应位置放上-1）。
     * 简单的例子：
     * input: 5,3,1,2,4
     * return: -1 3 1 1 -1
     */
    public int[] nextExceed(int[] input) {
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input ={5,3,1,2,4};
        int[] ints = new a_模板代码().nextExceed(input);
        System.out.println(Arrays.toString(ints));
    }
}
