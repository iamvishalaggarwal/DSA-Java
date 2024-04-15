import java.util.HashMap;
import java.util.Map;

/*
 * Problem:
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Example:
Input: nums = [1,2,3], k = 3
Output: 2
*/

public class CountSubarraysWithGivenSum {

    /*
     * Brute Force: picking every subarray and then check if sum same or not
     * TC: O(n^2)
     * SC: O(1)
     */
    // public static int subarraySum(int[] nums, int k) {
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    // int sum = 0;
    // for (int j = i; j < nums.length; j++) {
    // sum += nums[j];
    // if (sum == k) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    /*
     * Optimal Approach - Using Prefix Sum
     * 
     * TC: O(N logn)
     * SC: O(N)
     */
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;

        map.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            count += map.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, -7, 2, 3 };
        int sum = 2;
        System.out.print("Maximum Subarray = " + findAllSubarraysWithGivenSum(arr, sum));
        // System.out.print("Maximum Subarray = " + subarraySum(arr, sum));
    }
}
