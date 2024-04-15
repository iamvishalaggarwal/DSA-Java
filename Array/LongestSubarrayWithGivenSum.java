
// Problem: Longest subarray with given sum K(positive numbers only)
public class LongestSubarrayWithGivenSum {

    /*
     * Optimal Approach - Two Pointer (Sliding Window with Variable Size)
     * TC: O(2 * n)
     * SC: O(1)
     */
    public static int longestSubarrayWithSumK(int[] arr, long k) {
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;

        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum = sum - arr[left];
                // move forward left pointer
                left++; // removing elements from left i.e., decreasing size of subarray
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1); // Upper Bound - Lower Bound + 1
            }

            // move forward right pointer
            right++;
            if (right < arr.length) {
                sum += arr[right];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 1, 0, 0, 3 };
        int k = 2;
        System.out.print("Longest subarray length = " + longestSubarrayWithSumK(arr, k));
    }
}
