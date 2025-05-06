package Graph;

import java.util.*;

// Problem: Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two cells sharing a common edge is 1.
class Triplet {
    int row, col, step;

    Triplet(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

class Solution {
    // using BFS approach (kinda similar to rotten tomatoes)
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int result[][] = new int[n][m];
        Queue<Triplet> q = new LinkedList<>();
        int target = 0; // given
        // filling target nodes in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == target) {
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int dirs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            Triplet t = q.remove();
            int row = t.row;
            int col = t.col;
            int step = t.step;
            result[row][col] = step;
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x > -1 && y > -1 && x < n && y < m && !visited[x][y]) {
                    if (grid[x][y] != target) {
                        q.add(new Triplet(x, y, step + 1));
                        visited[x][y] = true;
                    }
                }
            }
        }
        return result;
    }
}