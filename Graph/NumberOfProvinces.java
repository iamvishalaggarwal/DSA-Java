package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    public void dfs(int curr, ArrayList<Integer> dfs, int[][] adj, int n) {
        dfs.add(curr);

        for (int i = 0; i < n; i++) {
            if (adj[curr][i] == 1 && curr != i && !dfs.contains(i)) {
                dfs(i, dfs, adj, n);
            }
        }
    }

    // TC: O(N) + O(V + 2E)
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(i)) {
                dfs(i, list, isConnected, n);
                count++;
            }
        }
        return count;
    }
}
