package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node, dis;

    public Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class ShortestPathInUndirectedGraph {
    // Using simple BFS - just storing the weights in the queue along with the node,
    // and as we are doing level by level so we don't need to update the weight,
    // because we will always go from lower to higher weights
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] result = new int[adj.size()];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            result[i] = -1;
        }

        q.add(new Pair(src, 0));
        result[src] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.node;
            int dis = p.dis;

            for (int val : adj.get(node)) {
                if (result[val] == -1) {
                    q.add(new Pair(val, dis + 1));
                    result[val] = dis + 1;
                }
            }
        }
        return result;
    }

}