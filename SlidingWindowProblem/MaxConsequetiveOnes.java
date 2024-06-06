package SlidingWindowProblem;

public class MaxConsequetiveOnes {
    /*
     * Brute force - find all the subarrays
     * TC: O(n*n)
     * SC: O(1)
     */
    // public static int longestOnes(int[] nums, int k) {
    // // finding the longests sequence of 1s with 'k' zeroes
    // int maxLen = 0;
    // for (int i = 0; i < nums.length; i++) {
    // int zeroes = k;
    // for (int j = i; j < nums.length; j++) {
    // if (nums[j] == 0) {
    // zeroes--;
    // }
    // if (zeroes == -1) {
    // break;
    // }
    // int len = j - i + 1;
    // maxLen = Math.max(maxLen, len);
    // }
    // }
    // return maxLen;
    // }

    /*
     * Better - Sliding window
     * TC: O(2n)
     * SC: O(1)
     */
    // public static int longestOnes(int[] nums, int k) {
    // int l = 0, r = 0, maxLen = 0;
    // int zeroes = 0;
    // while (r < nums.length) {
    // if (nums[r] == 0) {
    // zeroes++;
    // }
    // if (zeroes <= k) {
    // int len = r - l + 1;
    // maxLen = Math.max(maxLen, len);
    // } else {
    // while (l < nums.length - 1 && nums[l] != 0) {
    // l++;
    // }
    // l++;
    // zeroes--;
    // }
    // r++;
    // }
    // return maxLen;
    // }

    /*
     * Optimal - in this we are not moving 'l' till we find zero, we just move it by
     * one place and update the maxLen if zeroes are less than equals to k
     * TC: O(n)
     * SC: O(1)
     */
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, zeroes = 0;
        while (r < nums.length) {
            if (nums[r] == 0)
                zeroes++;
            if (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            if (zeroes <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        System.out.println("Max length of 1s = " + longestOnes(arr, 2));
    }
}
