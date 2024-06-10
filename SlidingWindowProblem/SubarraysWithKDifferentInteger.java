package SlidingWindowProblem;

import java.util.HashMap;
// import java.util.HashSet;

public class SubarraysWithKDifferentInteger {

    // public static int subarraysWithKDistinct(int[] nums, int k) {
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int j = i; j < nums.length; j++) {
    // set.add(nums[j]);
    // if (set.size() == k) {
    // count++;
    // } else if (set.size() > k) {
    // break;
    // }
    // }
    // }
    // return count;
    // }

    public static int subarraysWithAtmostKElements(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            if (map.size() <= k) {
                count = count + (r - l + 1); // here we need to add len, as we need to consider all the subarrays <= K
            }
            r++;
        }
        return count;
    }

    /*
     * Optimal -
     * TC: O(4n)
     * SC: O(2n)
     */
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostKElements(nums, k) - subarraysWithAtmostKElements(nums, k - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 2, 3 };
        int k = 3;
        System.out.println("Number of subarrays = " + subarraysWithKDistinct(arr, k));
    }
}
