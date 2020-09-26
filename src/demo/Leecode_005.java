package demo;

/**
 * @author River
 * @date 2020/7/25 7:27
 * @description 最长回文字符串  babda
 */
public class Leecode_005 {

    public String longestString(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        boolean[][] pd = new boolean[len][len];
        //  初始化对角线上的元素
        int begin = 0;
        int maxLne = 0;
        for (int i = 0; i < len; i++) {
            pd[i][i] = true;
        }

        // 从每一列开始循环
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 边界条件
                if (s.charAt(i) != s.charAt(j)) {
                    pd[i][j] = false;
                }else {
                    if (j-i < 3){
                        pd[i][j] = true;
                    }else {
                        pd[i][j] = pd[i + 1][j - 1];
                    }
                }
                if(pd[i][j] && j-i+1>maxLne){
                    maxLne = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLne);

    }

}
