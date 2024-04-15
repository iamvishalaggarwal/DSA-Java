
import java.util.Arrays;
import java.util.HashMap;

// Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
public class TwoSumProblem {

    /*
     ** Brute Force Approach - Iterating over all elements and checking sum
     ** TC: O(n * n)
     ** SC: O(1)
     * public static int[] twoSum(int[] nums, int target) {
     * int sum = 0;
     * int result[] = new int[2];
     * for (int i = 0; i < nums.length; i++) {
     * for (int j = i + 1; j < nums.length; j++) {
     * sum = nums[i] + nums[j];
     * if (sum == target) {
     * result[0] = i;
     * result[1] = j;
     * return result;
     * }
     * }
     * }
     * return result;
     * }
     */

    /*
     * Better aproach
     ** Using Hashing
     ** TC: O(n * log(n))
     ** SC: O(n)
     */

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result; // never reach, as there must be a number for 2 sum
    }

    /*
     * Optimal approach: Using two pointer -
     * but it will not tell us about the index, as we are sorting the array
     * 
     * TC: O(n + n log n)
     * SC: O(1)
     */
    public static String istwoSumExists(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 3, 1 };
        int target = 5;
        int result[] = twoSum(arr, target);
        System.out.print("Two sum indices = ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

}
