import java.util.ArrayList;

/*
 * Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
Input:
N = 5, array[] = {1,3,2,3,1)

Output
: 2 
 */

public class ReversePairs {

    // public static int reversePairs(int[] nums) {
    // int count = 0;
    // for (int i = 0; i < nums.length - 1; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // long val1 = nums[i];
    // long val2 = nums[j];
    // val2 = 2 * val2;
    // if (val1 > val2) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    /*
     * Optimal Approach: using merge sort
     * TC: O(2N*logN)
     * SC: O(N)
     */
    public static int reversePairs(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int right = mid + 1;
        int left = low;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int arr[], int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2 * arr[right])) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 3, 1 };
        System.out.println("Reverse Pairs = " + reversePairs(arr));
    }
}
