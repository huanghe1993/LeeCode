package code.BFS;

import util.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author River
 * @date 2020/4/19 10:17
 * @description
 */
public class 图的所有路径 {

    public static void main(String[] args) {

        // TODO 自动生成的方法存根
        ArrayList<ArrayList<Integer>> myList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= 5; i++) {
            myList.add(new ArrayList<Integer>());
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("D:\\Code\\java\\Leecode\\LeeCode\\src\\code\\BFS\\1");
            br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null) {
                String[] nodes = str.split(" ");
                int src = Integer.parseInt(nodes[0]);
                int des = Integer.parseInt(nodes[1]);
                if (!myList.get(src).contains(des)) {
                    myList.get(src).add(des);
                }
                if (!myList.get(des).contains(src)) {
                    myList.get(des).add(src);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        int length = 6;


        /* 定义节点数组 */
        Node[] node = new Node[length];
        for (int i = 0; i < length; i++) {
            node[i] = new Node();
            node[i].setName(i);
        }

        /* 定义与节点相关联的节点集合 */
        for (int i = 0; i < length; i++) {
            ArrayList<Node> List = new ArrayList<Node>();
            ArrayList<Integer> temp = myList.get(i);
            int len = temp.size();
            for (int j = 0; j < len; j++) {
                List.add(node[temp.get(j)]);
            }
            node[i].setRelationNodes(List);
            List = null;
        }
        /* 开始搜索所有路径 */
        new 图的所有路径().getPaths(node[0], node[1], node);
    }


    private void getPaths(Node src, Node des, Node[] nodes) {
        int num = 0;
        //	模拟队列
        ArrayList<Node> queueList = new ArrayList<Node>();
        //	存储下标
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        //	源节点入队
        queueList.add(src);
        //	设置源节点的父节点的下标为-1，做标志作用
        indexList.add(-1);
        int index = 0;
        //	存储连边，不能来回重复放置连边
        HashSet<String> set = new HashSet<String>();
        while (index < queueList.size()) {
            //	index即为目前队列的头结点
            Node top = queueList.get(index);
            //	如果是目的元素，则打印路径，目前设置了输出前三条路径
            if (top.name == des.name) {
                printPath(queueList, indexList, index);
                num = num + 1;
                if(num==3) {
                    System.exit(1);
                }
            }
            //	得到当前节点的邻接节点，并入队，并存储入队新节点的父节点的下标
            ArrayList<Node> relation = top.relationNodes;
            String edgeTopNode = null;
            String edgeNodeTop = null;
            for (Node node : relation) {
                edgeTopNode = top.name + "," + node.name;
                edgeNodeTop = node.name + "," + top.name;
                if (!set.contains(edgeTopNode) && !set.contains(edgeNodeTop)) {
                    queueList.add(node);
                    indexList.add(index);
                    set.add(edgeTopNode);
                }

            }
            index = index + 1;
        }
    }

    private void printPath(ArrayList<Node> queueList, ArrayList<Integer> indexList, int index) {
        System.out.print(queueList.get(index).name + "<-");
        index = indexList.get(index);
        if (index == -1) {
            System.out.println(queueList.get(0).name);
            return;
        }
        while (index != 0) {
            System.out.print(queueList.get(index).name + "<-");
            index = indexList.get(index);
        }
        System.out.println(queueList.get(0).name);
        return;
    }
}
