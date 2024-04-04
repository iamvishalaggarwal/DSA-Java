package Array;

import java.util.HashMap;

// Problem: The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
public class MajorityElement {

    /*
     * Better approach: Using Hashing
     * TC: O(n) + O(nlogn)
     * SC: O(n)
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        int n = nums.length;
        for (int val : map.keySet()) {
            if (map.get(val) > n / 2) {
                return val;
            }
        }
        return 0; // never reach
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.print("Majority element = " + majorityElement(arr));
    }
}
