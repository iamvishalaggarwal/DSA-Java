package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 */

public class FindEventualSafeStatesUsingDFS {

    public boolean dfs(int curr, int[][] graph, boolean[] visited, boolean[] pathVisited, List<Integer> safeNodes) {
        visited[curr] = true;
        pathVisited[curr] = true;

        for (int val : graph[curr]) {
            if (!visited[val]) {
                if (dfs(val, graph, visited, pathVisited, safeNodes)) {
                    return true; // if cycle found
                }
            } else {
                if (pathVisited[val]) {
                    return true;
                }
            }
        }
        pathVisited[curr] = false;
        safeNodes.add(curr); // if there is no cycle and reached end (i.e., terminal node),
                             // then we can mark it as safe node
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, pathVisited, safeNodes);
            }
        }
        // as we need to return this in ascending order
        return safeNodes.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
