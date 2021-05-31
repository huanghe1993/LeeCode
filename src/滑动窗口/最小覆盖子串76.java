package 滑动窗口;

import java.util.HashMap;

public class 最小覆盖子串76 {

    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        char[] charArray = t.toCharArray();
        for (Character c:charArray) {
            if (need.containsKey(c)){
                need.put(c,need.get(c)+1);
            }
            need.put(c,1);
        }
        int needCount = t.length();
        // 滑动窗口
        int left = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            sb.append(c);
            if(need.get(c) >0){
                need.put(c,need.get(c)-1);
                needCount = needCount -1;
            }
            while (needCount ==0){
                Character leftChar = chars[left];
                // 维护map中的元素，如果左边的不再维护的数组中直接的结束while
                if(need.get(leftChar)==0)
                    break;
                // 否则left在目标的target中，此时的left需要不断的,需要维护need和neeCount
                need.put(leftChar,need.get(leftChar)+1);
                needCount++;
            }

        }


    }
}
