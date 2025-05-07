package Graph;

public class SurroundedRegions {
    public void dfs(int m, int n, char[][] board, boolean[][] visited) {
        visited[m][n] = true;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] dir : dirs) {
            int x = m + dir[0];
            int y = n + dir[1];
            if (x > -1 && y > -1 && x < board.length && y < board[0].length && board[x][y] == 'O' && !visited[x][y]) {
                dfs(x, y, board, visited);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        // checking all 4 boundaries (for marking 0's and their connected 0's)
        int xBoundaries[] = { 0, m - 1 };
        for (int val : xBoundaries) {
            for (int i = 0; i < n; i++) {
                if (board[val][i] == 'O') {
                    dfs(val, i, board, visited);
                }
            }
        }
        int yBoundaries[] = { 0, n - 1 };
        for (int val : yBoundaries) {
            for (int i = 0; i < m; i++) {
                if (board[i][val] == 'O') {
                    dfs(i, val, board, visited);
                }
            }
        }

        // convert all unmarked 0's to X's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
