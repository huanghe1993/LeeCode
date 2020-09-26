package 双指针.头尾指针;

/**
 * @author River
 * @date 2020/9/26 15:07
 * @description
 */
public class Num11_盛水容器 {

    public int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int res = 0;
        while (left < right) {
            // 计算最大面积
            int width = right - left;
            int hei = Math.min(height[left], height[right]);
            int area = width * hei;
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new Num11_盛水容器().maxArea(height);
        System.out.println(maxArea);
    }
}
