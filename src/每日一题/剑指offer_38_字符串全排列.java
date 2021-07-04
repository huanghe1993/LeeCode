package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 剑指offer_38_字符串全排列 {

    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Arrays.sort(chars);
        dfs(chars, "", res, visited);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] chars, String s, Set<String> res, boolean[] visited) {
        if (s.length() == chars.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && visited[i - 1]) continue;
            visited[i] = true;
            dfs(chars, s + chars[i], res, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String s = "abbc";
        String[] permutation = new 剑指offer_38_字符串全排列().permutation(s);
        System.out.println(Arrays.toString(permutation));
    }
}
