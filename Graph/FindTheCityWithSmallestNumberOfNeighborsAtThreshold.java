package Graph;

/*
problem - 
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */

public class FindTheCityWithSmallestNumberOfNeighborsAtThreshold {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = (int) 1e8;
            }
        }

        for (int[] edge : edges) {
            cost[edge[0]][edge[1]] = edge[2];
            cost[edge[1]][edge[0]] = edge[2];
            // for diagonal row, when i==j
            cost[edge[0]][edge[0]] = 0;
            cost[edge[1]][edge[1]] = 0;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][via] != 1e8 && cost[via][j] != 1e8) {
                        // atmost threshold
                        int newCost = cost[i][via] + cost[via][j];
                        if (newCost <= distanceThreshold) {
                            cost[i][j] = Math.min(cost[i][j], newCost);
                        }
                    }
                }
            }
        }
        int minReachable = n + 1;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (cost[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // If count is smaller, or equal but city index is higher
            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }
        return city;
    }
}
