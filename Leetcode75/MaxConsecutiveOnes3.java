package Leetcode75;

class Solution {
    public int longestOnes(int[] nums, int k) {
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
}
