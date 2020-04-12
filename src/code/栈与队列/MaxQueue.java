package code.栈与队列;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author River
 * @date 2020/4/12 20:37
 * @description
 */
public class MaxQueue {

    LinkedList<Integer> queue;



    public MaxQueue() {
        queue = new LinkedList();

    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer max = queue.stream().max(((o1, o2) -> o1.compareTo(o2))).get();
        return max;
    }

    public void push_back(int value) {
        queue.addLast(value);

    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer num = queue.removeFirst();
        return num;
    }
}
