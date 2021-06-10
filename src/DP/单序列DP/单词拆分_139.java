package DP.单序列DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分_139 {

    /**
     *
     * @param s: leetcode
     * @param wordDict: leet code
     * @return 单词是否可以被拆分
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[n]：表示的是S[0->n]的子字符串是否可以被拆分
        // 状态转移方程：dp[n] = dp[n] || S[i+1->n] in wordDict && dp[i]
        // S[0->n] in wordDict return True
        // 其中i的范围是 0 ~ n-1

        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            dp[i] = set.contains(s.substring(0, i + 1));
            for (int j = 0; j < i; j++) {
                if (dp[i]) {
                    break;
                }
                // 递推表达式的含义是，dp[j] 可以被拆分，切在j到i的长度范围内可以被拆分的化就是
                // dp[i] 可以被拆分
                dp[i] = dp[i] || dp[j] && set.contains(s.substring(j + 1, i + 1));
            }
        }
        return dp[n - 1];
    }

    /**
     * 递归的方法求解单词是否可以被拆分
     * @param s 给出的字符串
     * @param wordDict 单词字典
     * @return True可以被拆分，False不可以被拆分
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean result = false;
        if (s.equals("")){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0,i+1))){
                result = result || wordBreak2(s.substring(i+1),wordDict);
            }
        }
        return result;
    }



}
