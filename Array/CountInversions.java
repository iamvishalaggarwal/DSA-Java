/*
Problem: 
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Example:
Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
 */

import java.util.ArrayList;

public class CountInversions {

    /*
     * Brute Force: comparing all pairs
     * 
     * TC: O(n^2)
     * SC: O(n)
     */
    // public static int inversionCount(int arr[]) {
    // int count = 0;
    // for (int i = 0; i < arr.length - 1; i++) {
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[i] > arr[j]) {
    // // System.out.println(arr[i] + ", " + arr[j]);
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    /*
     * Optimal Approach: using merge sort
     */
    public static int inversionCount(int arr[]) {
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
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        int right = mid + 1;
        int left = low;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
                count += mid - left + 1; // updating count, when arr[i] > arr[j]
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
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 5 };
        System.out.println("Inversion Count = " + inversionCount(arr));
    }
}
