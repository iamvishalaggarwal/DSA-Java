package Graph;

import java.util.Arrays;

public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis, (int) 1e8);
        dis[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            boolean isChange = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dis[u] != (int) 1e8 && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    isChange = true;
                }
            }
            // early break, if no changes occur in the relaxation process
            if (!isChange) {
                break;
            }
        }

        // Check for negative weight cycle
        // After V - 1 iterations, if any edge can still be relaxed, a negative cycle
        // exists.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dis[u] != (int) 1e8 && dis[u] + w < dis[v]) {
                return new int[] { -1 };
            }
        }

        return dis;
    }
}