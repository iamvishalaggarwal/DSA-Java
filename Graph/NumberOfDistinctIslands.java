package Graph;

import java.util.HashSet;

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

// TC: n * m * log(set(length)) + (n*m*4)
/**
 * Approach -
 * we need to find the land consist of 1's but should be distinct, so we need to
 * identify the shape of every dfs which we find, so for detecting shape we use
 * this algo - pick the first node of the dfs as base and then delete every node
 * coordinates from this base coordinates (also subtract in case of base, it
 * will give (0,0)) -> in this way we can identify the shape and then store them
 * in set for maintaing unique list
 */
public class NumberOfDistinctIslands {
    // using string because we need to check the order properly
    public String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

    void dfs(int row, int col, int[][] grid, boolean[][] visited, int baseRow, int baseCol, HashSet<String> set) {
        visited[row][col] = true;
        set.add(toString(row - baseRow, col - baseCol));
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, };
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
                // n * m * 4
                dfs(x, y, grid, visited, baseRow, baseCol, set);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        HashSet<HashSet<String>> resultSet = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    HashSet<String> set = new HashSet<>();
                    dfs(i, j, grid, visited, i, j, set);
                    resultSet.add(set);
                }
            }
        }
        return resultSet.size();
    }
}
