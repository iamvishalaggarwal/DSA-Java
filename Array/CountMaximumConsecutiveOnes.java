/* Problem: Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

*/
public class CountMaximumConsecutiveOnes {

    /**
     * Approach
     * TC: O(n)
     * SC: O(1)
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 1, 1 };
        System.out.print("Count Maximum Consecutive 1s = " + findMaxConsecutiveOnes(arr));
    }
}
