package Graph;

public class CountUndirectedGraphs {

    // In an undirected graph, there can be maximum n(n-1)/2 edges. We can choose to
    // have (or not have) any of the n(n-1)/2 edges. So, total number of undirected
    // graphs with n vertices is 2(n(n-1)/2).
    public long countGraphs(int n) {
        return (long) Math.pow(2, n * (n - 1) / 2);
    }
}