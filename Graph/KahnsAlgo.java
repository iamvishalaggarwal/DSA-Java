package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
TC:
Building adjacency list & indegree: O(V + E)
BFS traversal: O(V + E)
Total: O(V + E) (Optimal for DAG)
 */
public class KahnsAlgo {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        // need to insert - '0' indegree nodes in the queue, as we can put them in
        // the very starting of the topo sort order
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        return res;
    }

    // without converting to adj list
    // public static ArrayList<Integer> topoSortWithBFS(int V, int[][] edges) {
    // ArrayList<Integer> res = new ArrayList<>();
    // int[] indegree = new int[V];
    // Queue<Integer> q = new LinkedList<>();

    // // finding indegree (incoming edge count)
    // for (int[] edge : edges) {
    // indegree[edge[1]]++;
    // }
    // // need to insert - '0' indegree nodes in the queue, as we can put them in
    // the
    // // very starting of the topo sort order
    // for (int i = 0; i < V; i++) {
    // if (indegree[i] == 0)
    // q.add(i);
    // }

    // while (!q.isEmpty()) {
    // int curr = q.remove();

    // for (int[] edge : edges) {
    // int u = edge[0], v = edge[1];
    // if (curr == u && indegree[v] != 0) {
    // indegree[v]--;
    // if (indegree[v] == 0)
    // q.add(v);
    // }
    // }

    // res.add(curr);
    // }
    // return res;
    // }
}
