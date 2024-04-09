package Array;

public class MaximumSubarray {

    /*
     ** Brute Force:
     ** TC: O(n^2)
     ** SC: O(1)
     * public static int maxSubArray(int[] nums) {
     * int sum = 0, max = Integer.MIN_VALUE;
     * for (int i = 0; i < nums.length; i++) {
     * sum = 0;
     * for (int j = i; j < nums.length; j++) {
     * sum += nums[j];
     * if (sum > max) {
     * max = sum;
     * }
     * }
     * }
     * return max;
     * }
     */

    /*
     * Optimal Approach - Kadane's Algorithm
     * The intuition of the algorithm is not to consider the subarray as a part of
     * the answer if its sum is less than 0. A subarray with a sum less than 0 will
     * always reduce our answer and so this type of subarray cannot be a part of the
     * subarray with maximum sum.
     * 
     * TC: O(n)
     * SC: O(1)
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max)
                max = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, -7, 2, 3 };
        System.out.print("Maximum Subarray = " + maxSubArray(arr));
    }
}
