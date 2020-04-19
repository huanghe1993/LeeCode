package code.BFS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author River
 * @date 2020/4/19 12:10
 * @description
 */
public class GraphTest {

    public void findAllPath(GraphVertex source, GraphVertex target) {

        Map<String, Boolean> visited = new HashMap<>();

        // 使用双栈法来实现所有链路的查找
        Stack<GraphVertex> mainStack = new Stack<>();
        Stack<LinkedList<GraphVertex>> neighborStack = new Stack<>();

        // 监视邻接节点数量
        while (!mainStack.empty()) {
            // 将邻接栈的数组先弹出
            LinkedList<GraphVertex> curNeighbors = neighborStack.pop();

            // 如果邻接栈有元素可用，就将其堆放在 mainStack 上
            if (curNeighbors != null && curNeighbors.size() > 0) {
                GraphVertex nextVertex = curNeighbors.removeFirst();
                // 将其压栈压回去
                neighborStack.push(curNeighbors);
                // 如果存在下一个节点
                if (nextVertex != null) {
                    buildDualStack(nextVertex, mainStack, neighborStack, visited);
                }
            } else {
                // 将其压栈压回去，不然接下来的 cutdownDualStack 会导致 pop 两次
                neighborStack.push(curNeighbors);
                // 如果邻接节点是空数组，也削减一层
                cutdownDualStack(mainStack, neighborStack, visited);
                continue; // 继续下一次循环
            }

            // 查看 mainStack 栈顶元素
            GraphVertex peekNode = mainStack.peek();
            // 检查该元素是否是目标节点，则当前 mainStack 就是一条路径
            if (peekNode == target) {
                List<GraphVertex> tempResult = new ArrayList<GraphVertex>(mainStack);
                printResult(tempResult);
                // 削减一层
                cutdownDualStack(mainStack, neighborStack, visited);
            }
        }


    }


    // 根据当前节点构建双栈
    public void buildDualStack(GraphVertex vertex, Stack<GraphVertex> mainStack, Stack<LinkedList<GraphVertex>> neighborStack, Map<String, Boolean> visited) {

        if (vertex != null) {
            // 将主节点入栈
            mainStack.push(vertex);
            // 标记已被访问过
            visited.put(vertex.value, true);

            // 获取 vertex 的邻接节点
            LinkedList<GraphVertex> neighbors = vertex.getNeighbors().stream().filter((GraphVertex v) -> !visited.get(v.getValue())).collect(Collectors.toCollection(LinkedList::new));
            neighborStack.push(neighbors);
        }
    }


    /**
     * 削减双栈（让双栈都减少一层）
     *
     * @param mainStack     主栈
     * @param neighborStack 辅助栈
     * @param visited       是否被访问
     */
    public void cutdownDualStack(Stack<GraphVertex> mainStack, Stack<LinkedList<GraphVertex>> neighborStack, Map<String, Boolean> visited) {

        // 将目标元素从 mainStack 中弹出，
        GraphVertex droppedMain = mainStack.pop();

        // 同时标记当前节点可以再次访问
        if (droppedMain != null) {
            visited.put(droppedMain.getValue(), false);
        }

        // 同时一并将 neighborStack 弹出元素
        neighborStack.pop();
    }

    /**
     * 打印输出结果
     *
     * @param tempResult
     */
    private void printResult(List<GraphVertex> tempResult) {
        tempResult.stream().map(GraphVertex::getValue).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
    }


    public static void main(String[] args) {
        // https://segmentfault.com/a/1190000020445075
        GraphVertex vertex0 = new GraphVertex("0");
        GraphVertex vertex1 = new GraphVertex("1");
        GraphVertex vertex2 = new GraphVertex("2");
        GraphVertex vertex3 = new GraphVertex("3");
        GraphVertex vertex4 = new GraphVertex("4");
        GraphVertex vertex5 = new GraphVertex("5");
        GraphVertex vertex6 = new GraphVertex("6");
        GraphVertex vertex7 = new GraphVertex("7");
        GraphVertex vertex8 = new GraphVertex("8");

        Graph graph = new Graph();
        graph.addEdge(new GraphEdge(vertex0, vertex1));
        graph.addEdge(new GraphEdge(vertex0, vertex2));
        graph.addEdge(new GraphEdge(vertex1, vertex3));
        graph.addEdge(new GraphEdge(vertex1, vertex4));
        graph.addEdge(new GraphEdge(vertex3, vertex7));
        graph.addEdge(new GraphEdge(vertex4, vertex7));
        graph.addEdge(new GraphEdge(vertex4, vertex5));
        graph.addEdge(new GraphEdge(vertex2, vertex5));
        graph.addEdge(new GraphEdge(vertex2, vertex6));
        graph.addEdge(new GraphEdge(vertex5, vertex6));
        graph.addEdge(new GraphEdge(vertex6, vertex8));

        new GraphTest().findAllPath(vertex3, vertex6);
    }


}
