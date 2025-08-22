package Leetcode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferenceOfTwoArrays {
    private boolean isFound(int[] arr, int n) {
        for (int num : arr) {
            if (n == num)
                return true;
        }
        return false;
    }

    // TC: (2*n*m)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<Integer> distinct1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!isFound(nums2, nums1[i])) {
                distinct1.add(nums1[i]);
            }
        }
        result.add(new ArrayList<>(distinct1));

        HashSet<Integer> distinct2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!isFound(nums1, nums2[i])) {
                distinct2.add(nums2[i]);
            }
        }
        result.add(new ArrayList<>(distinct2));

        return result;
    }
}
