package BinarySearch;

/*
Problem: There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return true is in nums, or false if it is not in nums.

Example:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
*/
public class SearchInRotatedArray2 {
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }

            /*
             * Edge case: when we have duplicates
             * condition when arr[low] == arr[mid] == arr[high]
             */
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // check left half is sorted
            if (nums[low] <= nums[mid]) {
                // check element exists on left side or not
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1; // eliminate left half
                }
            }
            // check right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1; // eliminate right half
                }
            }
        }
        return false; // element not found
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 2, 2, 2 };
        int target = 0;
        System.out.println("Is element present? " + search(arr, target));
    }
}
