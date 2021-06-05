package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最长的子串包含最多两个字符_159 {

    int lengthOfLongestSubstringTwoDistinct(String s) {
        int left =0;
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while (map.size() > 2){
                Character c = s.charAt(left);
                if (map.get(c)==0){
                    map.remove(c);
                }
                left++;
            }
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }
}
