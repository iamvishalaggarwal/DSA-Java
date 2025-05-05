package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0; // No fresh oranges to begin with
        int minutes = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                for (int[] d : dirs) {
                    int x = p.a + d[0], y = p.b + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        rotted = true;
                        queue.add(new Pair(x, y));
                    }
                }
            }

            if (rotted)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
