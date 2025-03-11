package Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjList = new ArrayList<>();

        // as it is zero based indexing so we need to create 'n' size arraylist
        // but if it is 1 based indexing then it should be 'n+1' size
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // for undirected graph need to add both sides u to v and v to u
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
}
