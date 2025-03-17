package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // SC: O(3N) ~ O(N)
    // TC: O(N) + O(2E)
    // ==> number of nodes (while loop part) + number of degree (for loop part)
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visitedArray[] = new boolean[V]; // since, zero based indexing; size = no. of nodes
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // since, here starting vertex = 0 (given in problem)
        visitedArray[0] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            bfs.add(curr);

            // checking neighbours of current node
            for (int val : adj.get(curr)) {
                if (!visitedArray[val]) {
                    visitedArray[val] = true;
                    q.add(val);
                }
            }
        }
        return bfs;
    }
}
