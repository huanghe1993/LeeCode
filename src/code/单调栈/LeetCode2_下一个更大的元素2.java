package code.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode2_下一个更大的元素2 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length*2];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        int[] nums2 = new int[nums.length*2];
        System.arraycopy(nums,0,nums2,0,nums.length);
        System.arraycopy(nums,0,nums2,nums.length,nums.length);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                Integer index = stack.pop();
                // index位置的元素
                res[index] = nums2[i];
            }
            stack.push(i);
        }
        return Arrays.copyOf(res,nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] ints = new LeetCode2_下一个更大的元素2().nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));

    }
}
