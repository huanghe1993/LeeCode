package DFS和BFS.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 迷宫问题1_490 {

    private int columns;

    private int rows;

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        rows = maze.length;
        columns = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] font = queue.poll();
            if (font[0] == destination[0] && font[1] == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int newX = font[0] + direction[0];
                int newY = font[1] + direction[1];
                while (isInArea(newX, newY) && maze[newX][newY] != 1) {
                    newX = newX + direction[0];
                    newY = newY + direction[1];
                }
                newX = newX - direction[0];
                newY = newY - direction[1];
                if (!visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < columns;
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {3, 2};
        boolean b = new 迷宫问题1_490().hasPath(maze, start, destination);
        System.out.println(b);
    }
}
