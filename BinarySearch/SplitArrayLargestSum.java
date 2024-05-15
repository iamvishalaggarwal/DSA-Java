package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayLargestSum {

    public static int[] findMaxAndSum(int arr[]) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        int result[] = { max, sum };
        return result;
    }

    public static int findNumberOfSubarrays(int arr[], int maxSum) {
        int sum = arr[0];
        int numberOfSplits = 1;
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= maxSum) {
                sum += arr[i];
            } else {
                numberOfSplits++;
                sum = arr[i];
            }
        }
        return numberOfSplits;
    }

    // public static int splitArray(int[] nums, int k) {
    // int maxAndSum[] = findMaxAndSum(nums);

    // if (k > nums.length) {
    // return -1;
    // }
    // int max = maxAndSum[0];
    // int sum = maxAndSum[1];
    // for (int i = max; i <= sum; i++) {
    // int numberOfSplits = findNumberOfSubarrays(nums, i);
    // if (numberOfSplits <= k) {
    // return i;
    // }
    // }
    // return -1;
    // }

    public static int splitArray(int[] nums, int k) {
        int maxAndSum[] = findMaxAndSum(nums);

        if (k > nums.length) {
            return -1;
        }
        int low = maxAndSum[0];
        int high = maxAndSum[1];
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfSplits = findNumberOfSubarrays(nums, mid);
            if (numberOfSplits > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 1, 1, 1 };
        int k = 5; // split into k parts
        System.out.println("max sum of split array = " + splitArray(nums, k));
    }
}
