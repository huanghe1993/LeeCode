package code.BFS;

import java.util.Map;

/**
 * @author River
 * @date 2020/4/19 13:00
 * @description
 */
public class Graph {

    public boolean isDirected = false;

    public Map<String, GraphVertex> vertices;

    public Map<String, GraphEdge> edges;

    /**
     * 给图添加边
     * @return
     */
    public Graph addEdge(GraphEdge edge){
        if (this.edges.containsKey(edge.))

    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public Map<String, GraphVertex> getVertices() {
        return vertices;
    }

    public void setVertices(Map<String, GraphVertex> vertices) {
        this.vertices = vertices;
    }

    public Map<String, GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(Map<String, GraphEdge> edges) {
        this.edges = edges;
    }
}
