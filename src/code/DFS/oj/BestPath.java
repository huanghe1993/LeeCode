package code.DFS.oj;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BestPath {
    static final class Connection {
        int srcBoard;

        int snkBoard;

        int weight;

        Connection(int srcBoard, int snkBoard, int weight) {
            this.srcBoard = srcBoard;
            this.snkBoard = snkBoard;
            this.weight = weight;
        }
    }

    static final class Boardpair {
        int srcBoard;

        int snkBoard;

        Boardpair(int srcBoard, int snkBoard) {
            this.srcBoard = srcBoard;
            this.snkBoard = snkBoard;
        }
    }

    static final class BestSolution {
        int pathLength;

        int pathWeight;

        BestSolution(int pathLength, int pathWeight) {
            this.pathLength = pathLength;
            this.pathWeight = pathWeight;
        }
    }

    // 待实现函数，在此函数中填入答题代码
    private static List<Integer> getBestRoute(List<Boardpair> boardsList, List<Connection> connectionsList) {
        List<Integer> result = new ArrayList<>();
        for (Boardpair boardpair : boardsList) {
            List<BestSolution> bestSolutionList = new ArrayList<>();
            int pathLength = 0;
            int weight = 0;
            dfs(boardpair, connectionsList, bestSolutionList, pathLength, weight);
            if (bestSolutionList.size() == 0){
                result.add(-1);
                continue;
            }
            List<BestSolution> bestSolutions = bestSolutionList.stream().sorted(Comparator.comparing(e -> e.pathLength)).sorted(Comparator.comparing(e -> e.pathWeight)).collect(Collectors.toList());
            int bestWeight = bestSolutions.get(0).pathWeight;
            result.add(bestWeight);
        }
        return result;
    }

    private static void dfs(Boardpair boardpair, List<Connection> connectionList, List<BestSolution> bestSolutions, int pathLength, int weight) {
        int srcBoard = boardpair.srcBoard;
        int snkBoard = boardpair.snkBoard;
        for (int i = 0; i < connectionList.size(); i++) {
            Connection connection = connectionList.get(i);
            if (connection.srcBoard == srcBoard) {
                // 如果当前的连接的目标值与实际的值相等，则在几个值中进行比较获取出最优解
                if (connection.snkBoard == snkBoard) {
                    pathLength = pathLength + 1;
                    weight = weight + connection.weight;
                    BestSolution solution = new BestSolution(pathLength, weight);
                    bestSolutions.add(solution);
                } else {
                    pathLength = pathLength + 1;
                    weight = weight + connection.weight;
                    connectionList.remove(connection);
                    // 起点是连接点处的终点，终点还是目标值
                    Boardpair board = new Boardpair(connection.snkBoard, snkBoard);
                    dfs(board, connectionList, bestSolutions, pathLength, weight);
                    connectionList.add(connection);
                }
            }
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int nRow = cin.nextInt();
        int mRow = cin.nextInt();
        List<Connection> connectionsList = new ArrayList<>();
        for (int i = 0; i < nRow; i++) {
            int srcBoard = cin.nextInt();
            int destBoard = cin.nextInt();
            int weight = cin.nextInt();
            connectionsList.add(new Connection(srcBoard, destBoard, weight));
        }
        List<Boardpair> boardsList = new ArrayList<>();
        for (int i = 0; i < mRow; i++) {
            int srcBoard = cin.nextInt();
            int destBoard = cin.nextInt();
            boardsList.add(new Boardpair(srcBoard, destBoard));
        }
        cin.close();
        List<Integer> result = getBestRoute(boardsList, connectionsList);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


}
