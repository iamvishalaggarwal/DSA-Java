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

    public void prepareAdjacencyList(int[][] edges, Map<Integer, ArrayList<Integer>> adjMap, int V) {
        for (int i = 0; i < V; i++) {
            adjMap.put(i, new ArrayList<Integer>());
        }
        // preparing adjacency list
        for (int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
    }

    public boolean isCycle(int node, Map<Integer, ArrayList<Integer>> adjList, boolean visited[],
            int parent) {
        visited[node] = true;

        for (int val : adjList.get(node)) {
            if (!visited[val]) {
                // agr cycle mil jati h to thk hai, otherwise failure tak check krte rhenge
                // (i.e., false aane p further possible nodes p check krenge)
                if (isCycle(val, adjList, visited, node)) {
                    return true;
                }
            } else {
                // agr wo node jha se aaaiy h aur uska adjacent alg hai toh it means wha cycle h
                if (parent != val) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        prepareAdjacencyList(edges, adjList, V);

        boolean visited[] = new boolean[V];
        // for multiple components in graph
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycle(i, adjList, visited, -1)) {
                return true;
            }
        }
        return false;
    }
}