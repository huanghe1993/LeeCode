package code.单调栈;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode1_下一个更大的元素 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack =new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                Integer pop = stack.pop();
                map.put(nums2[pop],nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
