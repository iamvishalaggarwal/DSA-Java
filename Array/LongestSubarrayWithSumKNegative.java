package Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKNegative {

    /*
     ** Brute Force Approach - Traverse all subarrays and compare their sum
     ** TC: O(n^2)
     ** SC: O(1)
     * public static int longestSubarrayWithSumK(int[] arr, long k) {
     * int maxLen = 0;
     * for (int i = 0; i < arr.length; i++) {
     * long sum = 0; // for each subarray starts with 'i'
     * for (int j = i; j < arr.length; j++) {
     * sum += arr[j];
     * if (sum == k) {
     * maxLen = Math.max(maxLen, j - i + 1);
     * }
     * }
     * }
     * return maxLen;
     * }
     */

    /*
     * Optimal Approach : Using Hashing (Prefix Sum approach)
     * TC: O(n) or O(N logN)
     * SC: O(n)
     */
    public static int longestSubarrayWithSumK(int[] a, int k) {
        int n = a.length; // size of the array.

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i:
            sum += a[i];

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
        int arr[] = { -1, 1, 1 };
        int k = 1;
        System.out.print("Longest subarray length = " + longestSubarrayWithSumK(arr, k));
    }
}
