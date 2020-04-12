package code.栈与队列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author River
 * @date 2020/4/12 21:16
 * @description
 */
public class 滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0){
            return new int[0];
        }
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k+i; j++) {
                max =Math.max(max,nums[j]);
            }
            list.add(max);
        }
        int[] d = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            d[i] = list.get(i);
        }
        return d;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] ints = new 滑动窗口的最大值().maxSlidingWindow(nums, 0);
        System.out.println(Arrays.toString(ints));


    }
}
