package DP.单序列DP;

import java.util.Arrays;

public class 最大子序和_俄罗斯套娃信封问题_354 {

    public int maxEnvelopes(int[][] envelopes) {
        // 新建一个比较器Comparator作为匿名内部类
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] == o2[0]){
                // 若俩数组的第一个元素相等，则比较它们的第二个元素
                return o1[1] - o2[1];
            }else {
                // 若俩数组的第一个元素不相等，则按从小到大的顺序排列
                return o1[0] - o2[0];
            }
        });
        int len = envelopes.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] & envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int maxEnvelopes = new 最大子序和_俄罗斯套娃信封问题_354().maxEnvelopes(envelopes);
        System.out.println(maxEnvelopes);
    }
}
