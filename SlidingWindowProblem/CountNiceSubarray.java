package SlidingWindowProblem;

/*
 * Problem:
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 */

public class CountNiceSubarray {
    /*
     * This problem is same as binary subarray, only with a minor change
     * let's consider -
     * odd numbers = 1
     * even numbers = 0
     * eg: [1,5,2,1,1] == [1,1,0,1,1]
     * now it is same exact like before problem only with a minor change
     */
    public static int findSubarraysWithSmallerThanEqualsToGoal(int nums[], int goal) {
        int count = 0;
        int l = 0, r = 0;
        int sum = 0;
        // case when we have to find subarrays for sum = 0
        if (goal < 0)
            return 0;

        while (r < nums.length) {
            sum += (nums[r] % 2); // here we need to find modulo, as for even it will give 1 and for odd it will
                                  // give 0

            while (sum > goal) {
                sum -= (nums[l] % 2);
                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return findSubarraysWithSmallerThanEqualsToGoal(nums, k)
                - findSubarraysWithSmallerThanEqualsToGoal(nums, k - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println("Number of nice subarray = " + numberOfSubarrays(arr, k));
    }
}
