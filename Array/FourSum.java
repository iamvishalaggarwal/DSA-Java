import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /*
     * Brute Force: Using 3 Loops
     * TC: O(n^4)
     * SC: O(1)
     */
    // public static List<List<Integer>> fourSum(int[] nums, int target) {
    // List<List<Integer>> result = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // for (int l = k + 1; l < n; l++) {
    // if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
    // List<Integer> list = new ArrayList<>();
    // list.add(nums[i]);
    // list.add(nums[j]);
    // list.add(nums[k]);
    // list.add(nums[l]);
    // list.sort(null);
    // if (!result.contains(list)) {
    // result.add(list);
    // }
    // }
    // }
    // }
    // }
    // }

    // return result;
    // }

    /*
     * Optimal Solution: Using Two Pointers Approach
     * TC: O(n^3) + O(log n)
     * SC: O(4) [for storing triplet lists]
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> quadruples = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        quadruples.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }

        return quadruples;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
        int target = 9;
        System.out.println("3 Sum triplets are:");
        for (List<Integer> quads : fourSum(arr, target)) {
            System.out.println(quads);
        }
    }
}
