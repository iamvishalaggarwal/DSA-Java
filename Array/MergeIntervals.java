import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /*
     * Brute Force: Using two loops
     * 
     * TC: O(N logN) + O(2N)
     * SC: O(N)
     */
    // public static int[][] merge(int[][] intervals) {
    // int n = intervals.length;
    // int count = 0;

    // Comparator<int[]> comp = new Comparator<int[]>() {
    // @Override
    // public int compare(int[] o1, int[] o2) {
    // return o1[0] - o2[0];
    // }
    // };

    // // Step 1
    // Arrays.sort(intervals, comp); // needed comparator, as we have nested array

    // // step 2:
    // List<List<Integer>> list = new ArrayList<>();

    // for (int i = 0; i < n; i++) {
    // int start = intervals[i][0];
    // int end = intervals[i][1];

    // if (count != 0 && end <= list.get(list.size() - 1).get(1)) {
    // continue;
    // }

    // for (int j = i + 1; j < n; j++) {
    // if (intervals[j][0] <= end) {
    // // merging
    // end = Math.max(end, intervals[j][1]);
    // } else {
    // break;
    // }
    // }

    // list.add(Arrays.asList(start, end));
    // count++;
    // }

    // // converting into desired format
    // int[][] result = new int[list.size()][2];
    // for (int i = 0; i < list.size(); i++) {
    // result[i][0] = list.get(i).get(0);
    // result[i][1] = list.get(i).get(1);
    // }
    // return result;
    // }

    /*
     * Optimal Force: Using single loop
     * 
     * TC: O(N logN) + O(N)
     * SC: O(N)
     */
    public static int[][] merge(int[][] intervals) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        // Step 1
        Arrays.sort(intervals, comp);

        // step 2
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // if the current interval does not
            // lie in the last interval:
            // ie, if the current element is greater than the last inserted element
            if (resultList.isEmpty() || intervals[i][0] > resultList.get(resultList.size() - 1).get(1)) {
                resultList.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            // if the current interval
            // lies in the last interval:
            else {
                resultList.get(resultList.size() - 1).set(1,
                        Math.max(resultList.get(resultList.size() - 1).get(1), intervals[i][1]));
            }
        }

        // converting into desired format
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i][0] = resultList.get(i).get(0);
            result[i][1] = resultList.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 8, 10 }, };
        System.out.println("After overlapping intervals - ");
        for (int[] val : merge(intervals)) {
            for (int i : val) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
