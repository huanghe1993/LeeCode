package 剑指offer;

public class 剑指Offer12_矩阵中的路径DFS {

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = false;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (dfs(board, word, newX, newY, k + 1)) {
                res =  true;
                break;
            }
        }
        board[i][j] = word[k];
        return res;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        剑指Offer12_矩阵中的路径DFS obj = new 剑指Offer12_矩阵中的路径DFS();
        boolean exist = obj.exist(board, word);
        System.out.println(exist);
    }
}
