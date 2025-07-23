package Graph;

import java.util.ArrayList;

public class TopoSort {

    public static void reverse(ArrayList<Integer> arr) {
        int i = 0, j = arr.size() - 1;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    public static void dfs(int curr, ArrayList<Integer> res, int[][] edges, boolean[] visitedArray) {
        visitedArray[curr] = true;

        for (int[] edge : edges) {
            if (curr == edge[0] && !visitedArray[edge[1]]) {
                dfs(edge[1], res, edges, visitedArray);
            }
        }
        res.add(curr); // only storing the element when the dfs is completed == MAIN INTUITION
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visitedArray = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visitedArray[i]) {
                dfs(i, res, edges, visitedArray);
            }
        }
        reverse(res);
        return res;
    }
}
