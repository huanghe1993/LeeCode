package DFS和BFS.BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 迷宫问题2_505 {

    private int rows;

    private int columns;

    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int hasPath(int[][] maze, int[] start, int[] destination) {
        rows = maze.length;
        columns = maze[0].length;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(c -> c.dist));
        boolean[][] visited = new boolean[rows][columns];
        priorityQueue.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        while (!priorityQueue.isEmpty()) {
            Node font = priorityQueue.poll();
            for (int[] direction : directions) {
                // 获取到当前节点的距离
                int dist = font.dist;
                int newX = font.x + direction[0];
                int newY = font.y + direction[1];
                while (isInArea(newX, newY) && maze[newX][newY] != 1) {
                    newX = newX + direction[0];
                    newY = newY + direction[1];
                }
                newX = newX - direction[0];
                newY = newY - direction[1];
                if (!visited[newX][newY]) {
//                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }

        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < columns;
    }
}
