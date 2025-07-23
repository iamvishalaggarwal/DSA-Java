package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindEventualSafeStatesUsingBFS {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // step 1 - reversing the links
        for (int i = 0; i < n; i++) {
            indegree[i] = graph[i].length;
            if (indegree[i] == 0) {
                q.add(i);
            }
            for (int val : graph[i]) {
                adj.get(val).add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            safeNodes.add(curr);

            for (int val : adj.get(curr)) {
                if (indegree[val] != 0) {
                    indegree[val]--;
                    if (indegree[val] == 0) {
                        q.add(val);
                    }
                }
            }
        }
        return safeNodes.stream()
                .sorted().collect(Collectors.toList());
    }
}
