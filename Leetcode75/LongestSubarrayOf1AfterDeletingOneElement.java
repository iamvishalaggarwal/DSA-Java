package Leetcode75;

class Solution {
    // similar to consecutive 1's with max size
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        int zeroes = 0;
        while (j != nums.length) {
            if (nums[j] == 0) {
                zeroes++;
            }
            if (zeroes > 1) {
                if (nums[i] == 0) {
                    zeroes--;
                }
                i++;
            }

            if (zeroes <= 1) {
                max = Math.max(max, j - i + 1);
            }
            j++;
        }
        return max - 1; // excluding one element, as we need to delete only 1
    }
}