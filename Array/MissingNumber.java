package Array;

/**
 * Problem: Given an array nums containing n distinct numbers in the
 * range [1, n], return the only number in the range that is missing from the
 * array.
 */
public class MissingNumber {

    /*
     ** Optimal Approach:
     * TC - O(n)
     * SC - O(1)
     */
    public static int missingNumber(int[] nums, int n) {
        int sum = (n * (n + 1)) / 2;
        for (int val : nums) {
            sum -= val;
        }
        return sum;
    }

    /*
     ** Better Approach: Using hashing array (by storing frequency of each element),
     ** return the element whose frequency is 0
     ** TC: O(2n)
     ** SC: O(n)
     * public static int missingNumber(int[] nums, int n) {
     * // hash array should have 0 to n+1 numbers for storing [1, n]
     * int hash[] = new int[n + 1];
     * 
     * for (int i = 0; i < nums.length; i++) { // iterating over array for storing
     * it into hash array
     * hash[nums[i]] += 1;
     * }
     * 
     * for (int i = 1; i < n + 1; i++) {
     * if (hash[i] == 0) {
     * return i;
     * }
     * }
     * return -1; // when there is no missing in given array
     * }
     */

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5 };
        int n = 5;
        System.out.print("Element = " + missingNumber(arr, n));
    }
}
