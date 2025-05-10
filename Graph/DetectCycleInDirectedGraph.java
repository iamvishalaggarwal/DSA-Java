package Graph;

import java.util.*;

/**
 * Note:
 * - on the same path node has to be visited again
 */
class Solution {

    public boolean isCyclic(int curr, Map<Integer, ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[curr] = true;
        pathVisited[curr] = true;
        for (int node : adj.get(curr)) {
            if (!visited[node]) {
                if (isCyclic(node, adj, visited, pathVisited)) {
                    return true;
                }
            } else {
                if (pathVisited[node]) {
                    return true;
                }
            }
        }
        // during backtrack we need to omit the node from path, as now it is going to
        // different path
        pathVisited[curr] = false;
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        // Convert edge list to adjacency list
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        // as we need to track the path, as if the node lies in same path then there is
        // a cycle
        boolean[] pathVisited = new boolean[V];
        // if there are multiple components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
