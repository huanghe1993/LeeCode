package DFS和BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DFS经典题目 {

    private Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap();
        graph.put("A", new String[]{"B", "C"});
        graph.put("B", new String[]{"A", "C", "D"});
        graph.put("C", new String[]{"A", "B", "D", "E"});
        graph.put("D", new String[]{"B", "C", "E", "F"});
        graph.put("E", new String[]{"C", "D"});
        graph.put("F", new String[]{"D"});
        // 图构建完成
        new DFS经典题目().DFS_G(graph, "A");
    }

    private void DFS_G(HashMap<String, String[]> graph, String s) {
        HashSet<String> seen = new HashSet();
        stack.add(s);
        seen.add(s);
        while (stack.size() > 0) {
            String vertex = stack.pop();
            // 获取连接点
            String[] nodes = graph.get(vertex);
            for (String node : nodes) {
                if (!seen.contains(node)) {
                    stack.push(node);
                    seen.add(node);
                }
            }
            System.out.println(vertex);
        }
    }
}

