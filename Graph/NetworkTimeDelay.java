package Graph;

import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            result[i] = -1;
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(k, 0)); // pair = node, time
        result[k] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.x;
            int time = p.y;

            for (Pair pair : adj.get(node)) {
                int neighbour = pair.x;
                int currTime = pair.y;
                if (result[neighbour] == -1 || (time + currTime) < result[neighbour]) {
                    result[neighbour] = time + currTime;
                    q.add(new Pair(neighbour, time + currTime));
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] == -1)
                return -1;
            maxTime = Math.max(maxTime, result[i]);
        }
        return maxTime; // the minimum time it takes for all nodes to receive the signal = the maximum
                        // of individual times
    }
}