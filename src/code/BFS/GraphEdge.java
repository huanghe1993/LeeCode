package code.BFS;

/**
 * @author River
 * @date 2020/4/19 12:06
 * @description
 */
public class GraphEdge {

    public GraphVertex startVertex;

    public GraphVertex endVertex;

    public int weight;

    public GraphEdge(GraphVertex startVertex, GraphVertex endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = 0;
    }

    public GraphVertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(GraphVertex startVertex) {
        this.startVertex = startVertex;
    }

    public GraphVertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(GraphVertex endVertex) {
        this.endVertex = endVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
