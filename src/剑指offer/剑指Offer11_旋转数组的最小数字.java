package 剑指offer;

public class 剑指Offer11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int left = 0;
        // 3,4,5,6,7,1,2
        // 7,1,2,3,4,5,6
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // 二分查找一个非常重要的原则是不能把可能存在的解丢失
                right = mid;
            }
        }
        return numbers[left];

    }

    public static void main(String[] args) {
        剑指Offer11_旋转数组的最小数字 obj = new 剑指Offer11_旋转数组的最小数字();
        int[] numbers = {2, 2, 2, 2, 2};
        int i = obj.minArray(numbers);
        System.out.println(i);
    }
}
