package Graph;

/**
 * Bipartite graph is the graph in which we have to fill it with 2 colors only,
 * in such a way that no 2 adjacent nodes have same color
 * If two adjancent nodes have same color --> not bipartite
 * Note: the graph which contains odd cycles are always non-bipartite
 */
class Solution {

    public boolean isBipartite(int curr, int[] visited, int[][] graph, int parentColor) {
        for (int node : graph[curr]) {
            if (visited[node] == 0) {
                int color = parentColor == 1 ? 2 : 1;
                visited[node] = color;
                if (!isBipartite(node, visited, graph, color)) {
                    return false;
                }
            } else if (visited[node] == parentColor) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];

        // we need to fill two colors: 1 and 2
        // default is 0
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!isBipartite(i, visited, graph, 1))
                    return false;
            }
        }
        return true;
    }
}
