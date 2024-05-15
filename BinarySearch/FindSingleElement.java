package BinarySearch;

public class FindSingleElement {

    /*
     * Brute force: checking neighbouring elements
     * TC: O(n)
     * SC: O(1)
     */
    // public static int singleNonDuplicate(int arr[]) {
    // if (arr.length == 1) { // edge case for one element only
    // return arr[0];
    // }

    // for (int i = 0; i < arr.length; i++) {
    // if (i == 0) {
    // if (arr[i] != arr[i + 1]) {
    // return arr[i];
    // }
    // } else if (i == arr.length - 1) {
    // if (arr[i] != arr[i - 1]) {
    // return arr[i];
    // }
    // } else {
    // if (arr[i - 1] == arr[i] || arr[i] == arr[i + 1]) {
    // continue;
    // } else {
    // return arr[i];
    // }
    // }
    // }
    // return -1; // never reach, as array always have single element
    // }

    /*
     * Brute force 2: using xor
     * TC: O(n)
     * SC: O(1)
     */
    // public int singleNonDuplicate(int[] arr) {
    // int single = 0;
    // for (int val : arr) {
    // single ^= val;
    // }
    // return single;
    // }

    /*
     * Optimal : Using binary search concept
     * TC: O(logN)
     * SC: O(1)
     */
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0]; // edge case for one element only
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // check for neighbouring elements
            // if not equals to either of its neighbour ==> single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            // (even, odd) --> we are on the right half, need to eliminate left
            // (odd, even) --> we are on the left half, need to eliminate right

            // we are on left half
            if (mid % 2 == 1 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            } else {
                // we are on right half
                high = mid - 1;
            }
        }
        return -1; // never reach statement
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println("Single element = " + singleNonDuplicate(arr));
    }
}
