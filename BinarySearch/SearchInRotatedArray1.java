package BinarySearch;

/*
Problem: There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

Example:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

public class SearchInRotatedArray1 {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
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
        return -1; // element not found
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 0, 1, 2 };
        int target = 3;
        System.out.println("Element found at index = " + search(arr, target));
    }
}
