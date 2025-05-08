package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfCompleteComponents {
    public void dfs(int curr, Map<Integer, List<Integer>> adjList, boolean[] visited, int[] numOfVerticeEdge) {
        visited[curr] = true;
        numOfVerticeEdge[1] += adjList.get(curr).size(); // count all incident edges
        for (int node : adjList.get(curr)) {
            if (!visited[node]) {
                dfs(node, adjList, visited, numOfVerticeEdge);
                numOfVerticeEdge[0]++;
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        // prepare adjacency list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] numOfVerticeEdge = new int[2];
                numOfVerticeEdge[0]++; // vertex count
                dfs(i, adjList, visited, numOfVerticeEdge);
                // number of edges = nodes * [(nodes - 1)/2]
                // here we have undirected graph, so we are dividing edge count by 2, as they
                // are double in adj list
                if (numOfVerticeEdge[0] * (numOfVerticeEdge[0] - 1) / 2 == numOfVerticeEdge[1] / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
