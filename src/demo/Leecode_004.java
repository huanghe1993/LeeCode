package demo;

/**
 * @author River
 * @date 2020/7/23 7:25
 * @description
 */
public class Leecode_004 {

    /**
     * 方法1，合并数组，去中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMediaSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        double result = 0;
        if (len % 2 != 0) {
            result = getNum(nums1, nums2, len / 2);
        } else {
            result = getNum(nums1, nums2, len / 2 - 1) + getNum(nums1, nums2, len / 2) / 2;
        }
        return 0;
    }

    private double getNum(int[] nums1, int[] nums2, int k) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int cur = 0;
        if (i < nums1.length && j < nums2.length && cur < k) {
            if (nums1[i] < nums2[i]) {
                result[cur++] = nums1[i++];
            } else {
                result[cur++] = nums2[i++];
            }
        }
        while (i < nums1.length && cur <= k) {
            result[cur++] = nums1[i++];
        }
        while (j < nums2.length && cur <= k) {
            result[cur++] = nums2[j++];
        }
        return result[cur - 1];


    }
}
