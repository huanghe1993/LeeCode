package DFS和BFS;

import java.util.*;

public class BFS经典题目 {

    private Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap();
        graph.put("A", new String[]{"B", "C"});
        graph.put("B", new String[]{"A", "C", "D"});
        graph.put("C", new String[]{"A", "B", "D", "E"});
        graph.put("D", new String[]{"B", "C", "E", "F"});
        graph.put("E", new String[]{"C", "D"});
        graph.put("F", new String[]{"D"});
        // 图构建完成
        new BFS经典题目().BFS_G(graph, "A");
    }

    private void BFS_G(HashMap<String, String[]> graph, String s) {
        HashSet<String> seen = new HashSet();
        queue.add(s);
        seen.add(s);
        while (queue.size() > 0) {
            String vertex = queue.poll();
            // 获取连接点
            String[] nodes = graph.get(vertex);
            for (String node : nodes) {
                if (!seen.contains(node)) {
                    queue.offer(node);
                    seen.add(node);
                }
            }
            System.out.println(vertex);
        }
    }

    private Map<String, String> BFS_Short_Path(HashMap<String, String[]> graph, String s) {
        HashSet<String> seen = new HashSet();
        HashMap<String, String> parent = new HashMap<>();
        queue.add(s);
        seen.add(s);
        parent.put(s, null);
        while (queue.size() > 0) {
            String vertex = queue.poll();
            // 获取连接点
            String[] nodes = graph.get(vertex);
            for (String node : nodes) {
                if (!seen.contains(node)) {
                    queue.offer(node);
                    seen.add(node);
                    parent.put(node, vertex);
                }
            }
            System.out.println(vertex);
        }
        return parent;
    }
}
