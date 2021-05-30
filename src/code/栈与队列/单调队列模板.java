package code.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 单调队列模板 {

    /**
     * 假设有n个原始的序列，求解的是长度为K的区间的最大值
     * @param array 长度为n的序列
     * @param k 长度为k的区间的最大值
     */
    public void mnotonicQueueTemp(int[] array,int k){
        int n = array.length;
        // 队列存放的是元素在数组中的下标
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && array[i] > deque.getLast()){
                // 当前元素比队尾元素大的时候，需要进行去尾操作
                deque.pollLast();
            }
            // 把当前元素的下标插入到队尾
            deque.push(i);
            // 当i在大于求解的区间范围才会去头操作
            if (i >=k){
                // 判断队列的头部是否在求解的区间中
                while (!deque.isEmpty() && deque.getFirst()< i-k){
                    // 需要删除队列的头
                    deque.pollFirst();
                }
                // 取出队列的头部就是最大值
                System.out.println(array[deque.getFirst()]);
            }
        }
    }
}
