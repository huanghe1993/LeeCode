package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer13_机器人的运动范围 {

    private int rows;

    private int columns;

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public int movingCount(int m, int n, int k) {
        rows = m;
        columns = n;
        int count = 1;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] dir : directions) {
                int newX = node.x + dir[0];
                int newY = node.y + dir[1];
                if (inArea(newX, newY) && !visited[newX][newY] && getSum(newX, newY) <= k) {
                    queue.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private int getSum2(int x, int y) {
        return panduan(x) + panduan(y);
    }

    private int getSum(int x, int y) {
        String x1 = String.valueOf(x);
        String y1 = String.valueOf(y);
        char[] chars = x1.toCharArray();
        char[] charsY = y1.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum = sum + Integer.parseInt(String.valueOf(chars[i]));
        }
        for (int i = 0; i <charsY.length ; i++) {
            sum = sum + Integer.parseInt(String.valueOf(charsY[i]));
        }
        return sum;
    }

    int panduan(int x){
        if (x==100) return 1;
        if (x<=9) return x;
        return x/10+x%10;
    }



    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public static void main(String[] args) {
        int x =10;
        int y = 34;
        剑指Offer13_机器人的运动范围 obj = new 剑指Offer13_机器人的运动范围();
        int sum = obj.getSum(x, y);
        int m = 2, n = 3, k = 1;
        int i = obj.movingCount(m, n, k);
        System.out.println(i);
    }
}
