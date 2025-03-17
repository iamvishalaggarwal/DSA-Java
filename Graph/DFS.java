package Graph;

import java.util.ArrayList;

public class DFS {
    // SC: O(3N) [recursion space + adjacency list + visited]
    // --> for undirected graph
    // TC: O(N) + O(2*E) [number of nodes + summation of degree (2E)]
    // for directed graph - O(N + E)
    public void dfsOfGraph(int node, ArrayList<Integer> dfs, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        dfs.add(node);

        // getting neighbours
        for (int val : adj.get(node)) {
            if (!visited[val]) {
                dfsOfGraph(val, dfs, visited, adj);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[adj.size()]; // zero indexing

        visited[0] = true;
        // starting vertex = 0
        dfsOfGraph(0, dfs, visited, adj);
        return dfs;
    }
}
