package 剑指offer;

import java.util.*;

public class 剑指Offer12_矩阵中的路径BFS {

    private int rows;
    private int columns;
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.equalsIgnoreCase("")) {
            return true;
        }
        char[] chars = word.toCharArray();
        rows = board.length;
        columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == chars[0]) {
                    Queue<List<Node>> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[rows][columns];
                    queue.add(Collections.singletonList(new Node(i, j, chars[0])));
                    visited[i][j] = true;
                    boolean bfs = bfs(board, chars, queue,visited);
                    if (bfs) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, char[] chars, Queue<List<Node>> queue,boolean[][] visited) {
        int step = 1;
        while (!queue.isEmpty()) {
            List<Node> fonts = queue.poll();
            List<Node> array = new ArrayList<>();
            for (Node node : fonts) {
                if (step == chars.length && chars[step - 1] == node.c) {
                    return true;
                }
                for (int[] direction : directions) {
                    int newX = node.x + direction[0];
                    int newY = node.y + direction[1];
                    if (isInArea(newX,newY) && !visited[newX][newY] && board[newX][newY] == chars[step]) {
                        array.add(new Node(newX, newY, chars[step]));
                        visited[newX][newY] = true;
                    }
                }
            }
            if (!array.isEmpty()){
                queue.add(array);
            }
            step++;
        }
        return false;
    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < columns;
    }

    class Node {
        int x;
        int y;
        char c;

        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        char[][] board  = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        剑指Offer12_矩阵中的路径BFS obj = new 剑指Offer12_矩阵中的路径BFS();
        boolean exist = obj.exist(board, word);
        System.out.println(exist);
    }
}
