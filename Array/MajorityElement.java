package Array;

// import java.util.HashMap;

// Problem: The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
public class MajorityElement {

    /*
     ** Better approach: Using Hashing
     ** TC: O(n) + O(nlogn)
     ** SC: O(n)
     * public static int majorityElement(int[] nums) {
     * HashMap<Integer, Integer> map = new HashMap<>();
     * for (int val : nums) {
     * if (map.containsKey(val)) {
     * map.put(val, map.get(val) + 1);
     * } else {
     * map.put(val, 1);
     * }
     * }
     * int n = nums.length;
     * for (int val : map.keySet()) {
     * if (map.get(val) > n / 2) {
     * return val;
     * }
     * }
     * return 0; // never reach
     * }
     */

    /*
     * Optimal Approach
     * Moore's Voting Algo
     * TC: O(n) + O(n)
     * SC: O(1)
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        for (int val : nums) {
            if (count == 0) { // when count becomes zero
                element = val;
                count = 1;
            } else if (element == val) {
                count++; // for same element
            } else {
                count--; // for different element
            }
        }
        int count1 = 0;
        for (int val : nums) {
            if (element == val)
                count1++;
        }
        return count1 > nums.length / 2 ? element : -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.print("Majority element = " + majorityElement(arr));
    }
}
