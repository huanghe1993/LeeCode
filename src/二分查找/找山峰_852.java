package 二分查找;

public class 找山峰_852 {

    public int peakIndexInMountainArray(int[] arr) {
        // 想到O(n)的方案是非常的容易的，但是O(logn)的算法一般有二分和分治算法
        // 如果是二分查找是如何的进行查找呢
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            }
            // 左边比中间值高，说明山峰在左侧
            else if (arr[mid] < arr[mid - 1]) {
                right = mid;
                // 右边比中间值高，说明山峰在右边
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 3, 2, 0};
        int i = new 找山峰_852().peakIndexInMountainArray(a);
        System.out.println(i);
    }
}
