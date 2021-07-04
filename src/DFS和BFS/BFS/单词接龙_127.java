package DFS和BFS.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 单词接龙_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> seen = new HashSet<>();
        HashSet<String> wordListSet = new HashSet<>(wordList);
        seen.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            String font = queue.poll();
            if (font.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < beginWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char[] chars = font.toCharArray();
                    chars[i] = (char) (j + 'A');
                    String np = String.valueOf(chars);
                    if (wordListSet.contains(np) && !seen.contains(np)){
                        queue.add(np);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
