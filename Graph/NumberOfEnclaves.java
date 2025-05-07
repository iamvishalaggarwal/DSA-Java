package Graph;

// same like surrounded regions
class Solution {
    public void dfs(int m, int n, int[][] grid, boolean[][] visited) {
        visited[m][n] = true;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] dir : dirs) {
            int x = m + dir[0];
            int y = n + dir[1];
            if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
                dfs(x, y, grid, visited);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        // checking all 4 boundaries (for marking 0's and their connected 0's)
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, grid, visited);
            }
            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i, grid, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, visited);
            }
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid, visited);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}