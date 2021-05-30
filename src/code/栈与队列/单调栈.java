package code.栈与队列;

import java.util.Arrays;
import java.util.Stack;

public class 单调栈 {

    public int[] nextExceed(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < input.length; i++) {
            while (!stack.empty() && input[i] > input[stack.peek()]) {
                Integer stackTop = stack.pop();
                result[stackTop] = i - stackTop;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {5, 3, 1, 2, 4};
        int[] ints = new 单调栈().nextExceed(input);
        System.out.println(Arrays.toString(ints));
    }
}
