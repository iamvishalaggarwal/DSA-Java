package Leetcode75;

class Solution {
    // TC: O(2*N)
    // SC: O(2*N)
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int idx = -1;
        // prefix[0] = 0
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int suffix[] = new int[len];
        // suffix[len-1] = 0

        for (int i = len - 1; i >= 0; i--) {
            int add = i + 1 == len ? 0 : nums[i + 1];
            int suf = i + 1 == len ? 0 : suffix[i + 1];
            suffix[i] = suf + add;
            if (suffix[i] == prefix[i]) {
                idx = i;
            }
        }
        return idx;
    }

    // OPTIMIZED_VERSION
    // TC: O(2*N)
    // SC: O(1)
    public int pivotIndex_1(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // return immediately, ensures leftmost pivot
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
