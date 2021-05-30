package 堆;

import java.util.Arrays;

public class 堆排序 {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < n && tree[leftChild] > tree[max]) {
            max = leftChild;
        }
        if (rightChild < n && tree[rightChild] > tree[max]) {
            max = rightChild;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    public void insertElement(int[] tree, int num) {
        tree[tree.length] = num;

    }

    public void buildHeap(int[] tree, int n) {
        int parent = n / 2 - 1;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public void headSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            // 末尾的元素与第0个元素交换，把第0个位置的最大元素交换到末尾
            swap(tree, i, 0);
            // 交换之后只需要重新heapify第0个元素
            heapify(tree, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] tree = {4, 10, 3, 5, 1, 2};
        int n = 6;
        new 堆排序().headSort(tree, n);
        System.out.println(Arrays.toString(tree));
    }
}
