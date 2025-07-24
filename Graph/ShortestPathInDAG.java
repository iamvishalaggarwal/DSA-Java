package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ShortestPathInDAG {
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int[] result = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            result[i] = -1;
        }

        for (int[] edge : edges) {
            // Pair -> node, weight
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int src = 0;
        q.add(new Pair(src, 0));
        result[src] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.x;
            int dis = p.y;

            for (Pair pair : adj.get(node)) {
                int neighbour = pair.x;
                int weight = pair.y;
                if (result[neighbour] == -1 || (dis + weight) < result[neighbour]) {
                    result[neighbour] = dis + weight;
                    q.add(new Pair(neighbour, dis + weight));
                }
            }
        }
        return result;
    }
}
