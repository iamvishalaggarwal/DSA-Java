package Graph;

public class FloydWarshall {
    // User function template for JAVA

    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // checking infinity as there is no sense of adding inf + inf and storing again
                    if (dist[i][via] != 1e8 && dist[via][j] != 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }
}
