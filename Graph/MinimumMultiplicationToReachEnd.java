package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class MinimumMultiplicationToReachEnd {
    static int mod = 100_000;

    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        int[] dis = new int[mod]; // as we have to mode with 10^5
        Arrays.fill(dis, Integer.MAX_VALUE); // marking all position as infinity for starting
        q.add(new Pair(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.a;
            int step = p.b;

            if (node == end)
                return step;

            for (int val : arr) {
                int num = (val * node) % mod;
                if (step + 1 < dis[num]) {
                    dis[num] = step + 1;
                    q.add(new Pair(num, step + 1));
                }
            }
        }
        return -1;
    }
}
