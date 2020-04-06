package code.DFS;

/**
 * @author River
 * @date 2020/4/6 10:55
 * @description
 *  给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 *  一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 */
public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int islandNum = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == '1') {
                    ++islandNum;
                    dfs(grid, r, c);
                }
            }
        }
        return islandNum;
    }

    private void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int column = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        char[][] test ={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = new _200_岛屿数量().numIslands(test);
        System.out.println(i);

    }





}
