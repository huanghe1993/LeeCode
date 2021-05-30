package 堆;

/**
 * 最小堆的实现
 */
public class MinHeap {
    // 堆的存储结构数组
    private int[] tree;

    // 构造函数
    public MinHeap(int[] tree) {
        this.tree = tree;
        buildMinHeap();
    }

    /**
     * 构建小顶堆
     */
    public void buildMinHeap() {
        // 从第一个非叶子节点开始构建
        int parent = (tree.length / 2) - 1;
        for (int i = parent; i >= 0; i--) {
            // 对非叶子节点进行heapify
            heapify(i);
        }
    }

    public void heapify(int i) {
        int n = tree.length;
        if (i >= n) {
            return;
        }
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < n && tree[leftChild] < tree[max]) {
            max = leftChild;
        }
        if (rightChild < n && tree[rightChild] < tree[max]) {
            max = rightChild;
        }
        if (max != i) {
            swap(max, i);
            heapify(max);
        }
    }

    // 交换元素位置
    private void swap(int i, int j) {
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }

    // 获取对中的最小的元素，根元素
    public int getRoot() {
        return tree[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root) {
        tree[0] = root;
        heapify(0);
    }
}
