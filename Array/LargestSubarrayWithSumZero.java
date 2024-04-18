import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithSumZero {

    // public static int maxLen(int arr[]) {
    // int count = 0;
    // int max = 0;

    // for (int i = 0; i < arr.length; i++) {
    // int sum = 0;
    // count = 0;
    // for (int j = i; j < arr.length; j++) {
    // sum += arr[j];
    // count++;
    // if (sum == 0) {
    // max = Math.max(max, count);
    // }
    // }
    // }
    // return max;
    // }

    /*
     * Optimal: using prefix sum (Hashing)
     * TC: O(N*logN)
     * SC: O(N)
     */
    public static int maxLen(int arr[]) {
        int n = arr.length; // size of the array.
        int k = 0; // sum which we required
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i:
            sum += arr[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            // Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println("Subarray length = " + maxLen(arr));
    }
}
