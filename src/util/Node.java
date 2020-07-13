package util;

import java.util.ArrayList;

/**
 * @author River
 * @date 2020/4/19 10:15
 * @description
 */
public class Node {

    public int name = 0;

    public ArrayList<Node> relationNodes = new ArrayList<Node>();

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public ArrayList<Node> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(ArrayList<Node> relationNodes) {
        this.relationNodes = relationNodes;
    }
}
