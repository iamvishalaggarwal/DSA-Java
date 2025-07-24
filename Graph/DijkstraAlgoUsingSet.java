package Graph;

import java.util.*;

class Pair implements Comparable<Pair> {
    int node, dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair other) {
        // If distances are equal, sort by node to avoid duplicate entries
        if (this.dist == other.dist) {
            return this.node - other.node;
        }
        return this.dist - other.dist;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            // Uncomment below line if the graph is undirected
            // adj.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair top = set.pollFirst(); // Get and remove min distance node
            int node = top.node;
            int nodeDist = top.dist;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int weight = neighbor.dist;

                if (nodeDist + weight < dist[adjNode]) {
                    // Remove old pair if it exists
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new Pair(adjNode, dist[adjNode]));
                    }
                    dist[adjNode] = dist[node] + weight;
                    set.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }
}
