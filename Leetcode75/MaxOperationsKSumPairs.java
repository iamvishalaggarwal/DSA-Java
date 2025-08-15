package Leetcode75;

import java.util.Arrays;

public class MaxOperationsKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int ops = 0;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                ops++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return ops;
    }
}
