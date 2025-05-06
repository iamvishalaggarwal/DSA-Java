package Graph;

import java.util.*;

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {

    public boolean isCycle(int node, List<Integer>[] adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int curr = p.a;
            int parent = p.b;

            for (int neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    q.add(new Pair(neighbor, curr));
                    visited[neighbor] = true;
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }

        return false;
    }

    // TC: O(N + 2E), since sum of adjacent nodes = sum of degree = 2E
    public boolean isCycle(int V, int[][] edges) {
        // Convert edge list to adjacency list
        List<Integer>[] adj = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]); // undirected graph
        }

        boolean[] visited = new boolean[V];
        // if there are multiple components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycle(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
