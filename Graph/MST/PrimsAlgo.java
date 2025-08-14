package Graph.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Triplet {
    int a, b, c;

    public Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Solution {
    // TC: E logE
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // adjacency matrix conversion
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Triplet> q = new PriorityQueue<>((a, b) -> a.a - b.a); // min heap
        boolean[] vis = new boolean[V];
        // we can skip storing the parent as it is only required when we need to give
        // the list of MST's edges
        q.add(new Triplet(0, 0, -1));
        int sum = 0;

        while (!q.isEmpty()) {
            Triplet t = q.remove();
            int wt = t.a;
            int node = t.b;
            int parent = t.c;
            if (vis[node])
                continue;
            vis[node] = true;

            if (parent != -1) {
                sum += wt;
            }

            for (Pair p : adj.get(node)) {
                int neighbor = p.a;
                int weight = p.b;
                if (!vis[neighbor]) {
                    q.add(new Triplet(weight, neighbor, node));
                }
            }
        }
        return sum;
    }
}
