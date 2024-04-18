// import java.util.ArrayList;

/*
 * Problem: 
Given two non-decreasing sorted arrays, ‘A’ and ‘B’, having ‘N’ and ‘M’ elements, respectively.
When ‘N’ = 4, ‘A’ = {1, 4, 5, 7} and ‘M’ = 3, ‘B’ = {2, 3, 6}. 
We can merge these two arrays into {1, 2, 3, 4, 5, 6, 7} (The elements of ‘A’ are {1, 2, 3, 4}
and B are {5, 6, 7}).
 */

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    /*
     * Brute Force: Using extra space
     * TC: O(n+m) + O(n+m)
     * SC: O(n+m)
     */
    // public static void mergeTwoSortedArraysWithoutExtraSpace(int[] a, int[] b)
    // {
    // ArrayList<Integer> list = new ArrayList<>();
    // int left = 0;
    // int right = 0;
    // int n = a.length;
    // int m = b.length;
    // while (left < n && right < m) {
    // if (a[left] <= b[right]) {
    // list.add(a[left]);
    // left++;
    // } else {
    // list.add(b[right]);
    // right++;
    // }
    // }
    // while (left < n) {
    // list.add(a[left]);
    // left++;
    // }
    // while (right < m) {
    // list.add(b[right]);
    // right++;
    // }
    // for (int i = 0; i < n; i++) {
    // a[i] = list.get(i);
    // }

    // for (int i = 0; i < m; i++) {
    // b[i] = list.get(i + n);
    // }
    // }

    public static void swap(int arr1[], int arr2[], int index1, int index2) {
        int temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
    }

    /*
     * Optimal Approach - Using swap and sort technique
     * 
     * TC: O(min(n, m)) + O(n logn) + O(m logm)
     * SC: O(1)
     */
    public static void mergeTwoSortedArraysWithoutExtraSpace(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {
            // if left element greater than right element
            // swap left and right of a and b respectively
            if (a[left] > b[right]) {
                swap(a, b, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }

        // now, after swapping sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int a[] = { 0, 6, 6, 6, 6, 6, 7, 8 };
        int b[] = { 5, 5, 6, 6, 8 };
        mergeTwoSortedArraysWithoutExtraSpace(a, b);

        System.out.println("Arrays after sorting - ");
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : b) {
            System.out.print(val + " ");
        }
    }
}
