package Graph;

import java.util.*;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 */

/*
Problem Summary
- You must find the shortest path from (0, 0) to (n-1, n-1) in a binary matrix
- You can move in 8 directions.
- You can only step on 0s (not 1s).
- Return the number of steps (cells visited) or -1 if unreachable.
 */

class Triplet {
    int row, col, dis;

    public Triplet(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<Triplet> q = new LinkedList<>();
        int[][] weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }
        int srcRow = 0, srcCol = 0;
        weight[srcRow][srcCol] = 1;
        q.add(new Triplet(srcRow, srcCol, 1));

        // 8-directions
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

        while (!q.isEmpty()) {
            Triplet t = q.remove();
            int row = t.row;
            int col = t.col;
            int dis = t.dis;

            if (row == n - 1 && col == n - 1)
                return dis;

            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x < n && y < n && x >= 0 && y >= 0 && grid[x][y] == 0 && weight[x][y] > (dis + 1)) {
                    weight[x][y] = dis + 1;
                    q.add(new Triplet(x, y, dis + 1));

                }
            }
        }
        return -1;
    }
}