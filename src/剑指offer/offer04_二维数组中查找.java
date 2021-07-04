package 剑指offer;

public class offer04_二维数组中查找 {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix 的二维数组中
     * @param target 目标值
     * @return true存在，false不存在
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0) {
            return false;
        }
        // 获取第0行元素，通过二分查找找到第一个小于等于target的列
        int[] firstLine = matrix[0];
        if (firstLine.length == 0) {
            return false;
        }
        int columnIndex = findIndex(firstLine, target, true);
        if (columnIndex == -1 || columnIndex == matrix[0].length) {
            return false;
        }
        if (firstLine[columnIndex] == target) {
            return true;
        }
        int[] columnLine = new int[length];
        for (int i = 0; i < length; i++) {
            columnLine[i] = matrix[i][columnIndex];
        }
        // 找到小于等于target的之后一个元素
        int index2 = findIndex(columnLine, target,true);
        if (index2 == -1 || index2 == matrix.length || (index2 == matrix.length-1 && columnLine[index2] != target)) {
            return false;
        }
        if (columnLine[index2] == target) {
            return true;
        }
        int row = index2 + 1;
        return findIndex2(matrix[row], target);
    }

    /**
     * [1,   4], 找到小于等于target的最后一个元素
     *
     * @param array  数组
     * @param target 目标值
     * @return 下标
     */
    public int findIndex(int[] array, int target, boolean findLeft) {
        int left = -1;
        int right = array.length;
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            // blue
            if (target >= array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return findLeft ? left : right;
    }

    /**
     * [1,   4,  7, 11, 15],
     *
     * @param array  数组
     * @param target 目标值
     * @return 下标
     */
    public boolean findIndex2(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArraySol3(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (target == cur) {
                return true;
            } else if (target > cur) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//              {1,   4,  7, 11, 15},
//              {2,   5,  8, 12, 19},
//              {3,   6,  9, 16, 22},
//              {10, 13, 14, 17, 24},
//              {18, 21, 23, 26, 30}
//            };
//        int[][] matrix = {{1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}};

        int[][] matrix = {{2,5},
                          {2,8},
                          {7,9},
                          {7,11},
                          {9,11}};


        offer04_二维数组中查找 obj = new offer04_二维数组中查找();
        int[] array = matrix[0];
        int index = obj.findIndex(array, 7,true);
        boolean numberIn2DArray = obj.findNumberIn2DArray(matrix, 7);
        System.out.println(index);
        System.out.println(numberIn2DArray);


    }

}
