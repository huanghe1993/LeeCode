package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class 第一个比自己大的元素 {

    public int[] findFirstLarger(int[] inputs) {
        int[] result = new int[inputs.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < inputs.length; i++) {
            // 当第i个个位置的元素要比栈顶位置的元素大的时候，需要弹出栈顶的元素
            while (!stack.empty() && inputs[i] > inputs[stack.peek()]) {
                Integer stackTopIndex = stack.pop();
                result[stackTopIndex] = i - stackTopIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 4, 5, 2, 9, 6};
        int[] ints = new 第一个比自己大的元素().findFirstLarger(input);
        System.out.println(Arrays.toString(ints));
    }
}
