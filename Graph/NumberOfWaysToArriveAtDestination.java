package Graph;

import java.util.*;

class Pair {
    int x;
    long y;

    public Pair(int x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        long[] distance = new long[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.y, b.y));

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            distance[i] = Long.MAX_VALUE;
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        q.add(new Pair(0, 0));
        distance[0] = 0;
        ways[0] = 1;
        int mod = (int) (1e9 + 7);

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int curr = p.x;
            long dis = p.y;

            if (dis > distance[curr])
                continue;

            for (Pair pair : adj.get(curr)) {
                int adjNode = pair.x;
                long newDis = pair.y + dis;

                if (distance[adjNode] > newDis) {
                    distance[adjNode] = newDis;
                    q.add(new Pair(adjNode, newDis));
                    ways[adjNode] = ways[curr];
                } else if (newDis == distance[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[curr]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
