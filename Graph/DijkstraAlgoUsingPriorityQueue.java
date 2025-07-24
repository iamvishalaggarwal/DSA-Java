package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class DijkstraAlgoUsingPriorityQueue {
    public int[] shortestPath(int V, int E, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // NOTE: need to use lambda function - with custom comparator
        // else it will raise error - class Pair cannot be cast to class Comparable
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.y - b.y);
        int[] result = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            result[i] = -1; // marking as -1 or we can also use infinity - Integer.MAX_VALUE;
        }

        for (int[] edge : edges) {
            // Pair -> node, weight
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

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
