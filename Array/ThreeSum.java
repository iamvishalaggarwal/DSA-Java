import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.HashSet;
import java.util.List;

/**
 * Problem:
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example :
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 */

public class ThreeSum {

    /*
     * Brute Force: Using 3 Loops
     * TC: O(n^3)
     * SC: O(1)
     */
    // public static List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> triplestList = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // List<Integer> triplet = new ArrayList<>();
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // triplet.add(nums[i]);
    // triplet.add(nums[j]);
    // triplet.add(nums[k]);
    // // since, we need to store unique triplets, we need to sort and then store
    // Collections.sort(triplet);
    // if (!triplestList.contains(triplet)) {
    // triplestList.add(triplet);
    // }

    // }
    // }
    // }
    // }

    // return triplestList;
    // }

    /*
     * Better Approach: Using Hashing
     * TC: O(n^2) + O(log n)
     * SC: O(n)
     */
    // public static List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> triplestList = new ArrayList<>();

    // for (int i = 0; i < nums.length; i++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int j = i + 1; j < nums.length; j++) {
    // int k = -(nums[i] + nums[j]);
    // if (set.contains(k)) {
    // List<Integer> triplet = new ArrayList<>();
    // triplet.add(nums[i]);
    // triplet.add(nums[j]);
    // triplet.add(k);

    // Collections.sort(triplet);
    // if (!triplestList.contains(triplet)) {
    // triplestList.add(triplet);
    // }
    // }
    // set.add(nums[j]);
    // }
    // }
    // return triplestList;
    // }

    /*
     * Optimal Solution: Using Two Pointers Approach
     * TC: O(n^2) + O(log n)
     * SC: O(3) [for storing triplet lists]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplestList = new ArrayList<>();

        Arrays.sort(nums); // Step 1: sort the array

        for (int i = 0; i < nums.length; i++) {
            // for skipping duplicated 'i'
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    triplestList.add(list);
                    j++;
                    k--;
                    // skipping j, if it is equals to prev j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // skipping k, if it is equals to prev k
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return triplestList;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };

        System.out.println("3 Sum triplets are:");
        for (List<Integer> triplet : threeSum(arr)) {
            System.out.println(triplet);
        }
    }
}
