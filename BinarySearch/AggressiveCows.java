package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean isPossibleToAllocateStallToCows(int arr[], int minDistance, int numberOfCows) {
        int countOfCows = 1;
        int lastCow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastCow] >= minDistance) {
                lastCow = i;
                countOfCows++;
            }
            if (countOfCows == numberOfCows) {
                return true;
            }
        }
        return false;
    }

    // public static int findMaximumDistanceBetweenStalls(int arr[], int k) {
    // Arrays.sort(arr); // sort the array
    // int min = arr[0];
    // int max = arr[arr.length - 1];
    // for (int i = 1; i <= max - min; i++) {
    // // array, minimum distance, number of cows
    // if (isPossibleToAllocateStallToCows(arr, i, k)) {
    // } else {
    // return i - 1; // needs to return last possible combination
    // }
    // }
    // return -1; // never reach
    // }

    public static int findMaximumDistanceBetweenStalls(int arr[], int k) {
        Arrays.sort(arr); // sort the array
        int min = arr[0];
        int max = arr[arr.length - 1];
        int low = 1; // possible ans
        int high = max - min; // not possible ans
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossibleToAllocateStallToCows(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // according to polarity change philosophy, high becomes possible ans and
        // low becomes not possible ans
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 9 };
        int k = 3;
        System.out.println("Maximum distance between stalls = " + findMaximumDistanceBetweenStalls(arr, k));
    }
}
