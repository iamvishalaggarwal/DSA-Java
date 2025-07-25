package Graph;

import java.util.*;

class Triplet {
    // effort = absolute diff. of consecutive cells
    int effort, row, col;

    public Triplet(int x, int y, int z) {
        this.effort = x;
        this.row = y;
        this.col = z;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] weight = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> q = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        q.add(new Triplet(0, 0, 0));
        weight[0][0] = 0;
        int minEffort = Integer.MAX_VALUE;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Triplet t = q.remove();
            int row = t.row;
            int col = t.col;
            int effort = t.effort; // or difference

            // as in PQ we are storing efforts in ascending order, so whenever we get the
            // destination, we can directly return because we know in future we will not get
            // any more efficient path
            if (row == n - 1 && col == m - 1) {
                return effort;
            }
            for (int[] dir : dirs) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    // effort = max of difference
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if (newEffort < weight[newRow][newCol]) {
                        q.add(new Triplet(newEffort, newRow, newCol));
                        weight[newRow][newCol] = newEffort;
                    }
                }
            }
        }
        return minEffort;
    }
}