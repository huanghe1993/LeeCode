package code.DFS;

/**
 * @author River
 * @date 2020/4/6 12:18
 * @description
 */
public class _695_岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                    result = Math.max(result, dfs(grid, r, c));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        int row = grid.length;
        int column = grid[0].length;
        if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int result = 1;
        result = result + dfs(grid, r - 1, c);
        result = result + dfs(grid, r + 1, c);
        result = result + dfs(grid, r, c-1);
        result = result + dfs(grid, r, c+1);

        return result;

    }

    public static void main(String[] args) {
        int[][] test ={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int i = new _695_岛屿的最大面积().maxAreaOfIsland(test);
        System.out.println(i);
    }

}
