package BinarySearch;

/*
Problem: A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

Example:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

*/

public class FindPeakElement {

    /*
     * Brute force -
     * TC: O(N)
     * SC: O(1)
     */
    // public static int findPeakElement(int arr[]) {
    // if (arr.length == 1) { // edge case for one element only
    // return 0;
    // }

    // for (int i = 0; i < arr.length - 1; i++) {
    // if (i == 0) {
    // if (arr[i] > arr[i + 1]) {
    // return i;
    // }
    // } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
    // return i;
    // }
    // }

    // if (arr[arr.length - 1] > arr[arr.length - 2]) {
    // return arr.length - 1;
    // }

    // return -1; // never reach
    // }

    /*
     * Optimal - Using binary search concept
     * TC: O(logN)
     * SC: O(1)
     */
    public static int findPeak(int nums[]) {
        int n = nums.length;
        // case 1 : for only 1 element in array
        if (n == 1) {
            return 0;
        }

        // case 2: for first element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // case 3: for last element
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) { // lying on increasing path
                low = mid + 1;
            } else { // lying on decreasing path
                high = mid - 1;
            }
        }

        return -1; // never reach
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        System.out.println("peak element = " + arr[findPeak(arr)]);
    }
}
