package code.BFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author River
 * @date 2020/4/19 12:04
 * @description
 */
public class GraphVertex {

    public String value;

    public Map<String, GraphEdge> edges;

    /**
     * 获取所有当前节点的相邻节点
     *
     * @returns {GraphVertex[]}
     */
    public List<GraphVertex> getNeighbors(){
        List<GraphEdge> edges = (List<GraphEdge>) this.getEdges().values();
        edges.forEach(edges ->{

        });
    }

    public GraphVertex(String value, Map<String, GraphEdge> edges) {
        this.value = value;
        this.edges = edges;
    }

    public GraphVertex(String value) {
        this.value = value;
        this.edges = new HashMap<String, GraphEdge>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(Map<String, GraphEdge> edges) {
        this.edges = edges;
    }
}
