package BinarySearch;

public class KthMissingNumber {

    public static boolean isFound(int arr[], int element) {
        for (int val : arr) {
            if (val == element) {
                return true;
            }
        }
        return false;
    }

    /*
     * Brute force: search all mising element from 1 to max (max element of array)
     * and find the Kth missing
     * TC: O(n) * O(max) ~ O(n^2)
     * SC: O(1)
     */
    // public static int findKthPositive(int[] arr, int k) {
    // int missing = 0;
    // int max = arr[arr.length - 1];
    // for (int i = 1; i <= max; i++) {
    // if (!isFound(arr, i)) {
    // missing++;
    // if (missing == k) {
    // return i;
    // }
    // }
    // }
    // // if somehow few missing found, but not the Kth missing,
    // // so we need to find it at the end
    // // example: arr = [5,6,7,8,9] k = 9
    // return max + k - missing;
    // }

    /*
     * Better approach:
     * TC: O(n)
     * SC: O(1)
     */
    // public static int findKthPositive(int[] arr, int k) {
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] <= k) {
    // k++;1
    // } else
    // break;
    // }
    // return k;
    // }

    /*
     * Optimal Approach - Using binary search - we are keeping track of missing
     * numbers
     */
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // element - index + 1
            int missing = arr[mid] - (mid + 1); // finding number of missing elements till this index
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // since, result ==> arr[high] + more ==> arr[high] + (k - missing)
        // as arr[high] is on the position where number of missing elements
        // is less than k
        return high + 1 + k; // or low + k
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 };
        int k = 10;
        System.out.println("Kth missing number = " + findKthPositive(arr, k));
    }
}
