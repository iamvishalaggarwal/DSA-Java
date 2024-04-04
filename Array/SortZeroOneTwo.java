package Array;

/**
 * SortZeroOneTwo:
 * Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write a
 * function that sorts the given array. The functions should put all 0s first,
 * then all 1s and all 2s in last.
 * 
 * This problem is also the same as the famous “Dutch National Flag problem”.
 */
public class SortZeroOneTwo {

    /*
     ** Brute Force Approach
     ** TC: O(n logn)
     ** SC: O(1)
     * public void sortArray(int[] nums) {
     * Arrays.sort(nums);
     * }
     */

    public static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
     * Optimal Approach: Dutch National flag algorithm
     * TC: O(n)
     * SC: O(1)
     */
    public static void sortArray(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 2, 1, 1, 0 };
        sortArray(arr);
        System.out.print("After sorting array of 0's, 1's and 2's = ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}