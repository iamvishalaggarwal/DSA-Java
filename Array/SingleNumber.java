package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Probelm : Given a non-empty array of integers nums, every element appears
 * twice except for one. Find that single one.
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */

public class SingleNumber {

    /*
     * Better Approach - Using HashMap
     * TC: O(n) + O(n/2 + 1)
     * SC: O(n/2 + 1) --> as we are storing n/2 + 1 elements in map,
     * since every element appear twice except one
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 1, 2 };
        System.out.print("Single Number = " + singleNumber(arr));
    }
}
