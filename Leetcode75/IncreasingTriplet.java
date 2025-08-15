package Leetcode75;

import java.util.Arrays;

/*
Goal - 
- find triplet which is - 
    strictly increasing
    must be a subsequence (ordering is imp)
 */

public class IncreasingTriplet {
    // firstly we find the smaller value in the 'first', then if it is no longer
    // smaller than 'first', so we update the 'second' and if we further find the
    // number which is no longer
    // smaller than second, then this is the moment we find the triplet
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first) {
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

}

// for k-increasing subsequence

class Solution {
    // TC: (n*k)
    public boolean kIncreasingTriplet(int[] nums) {
        int k = 3; // for triplet
        // k-increasing subsequence - TC: O(NK)
        int check[] = new int[k];
        Arrays.fill(check, Integer.MAX_VALUE);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (nums[i] <= check[j]) {
                    check[j] = nums[i];
                    break;
                }
            }
            if (check[k - 1] != Integer.MAX_VALUE)
                return true;
        }
        return false;
    }
}