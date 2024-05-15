package BinarySearch;

import java.util.ArrayList;

/*
Problem: Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 */

public class MedianSortedArrays {
    /*
     * Brute force - storing both sorted array in temp array
     * and then find the median
     */
    // public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // ArrayList<Integer> list = new ArrayList<>();
    // int i = 0;
    // int j = 0;
    // while (i < nums1.length && j < nums2.length) {
    // if (nums1[i] < nums2[j]) {
    // list.add(nums1[i]);
    // i++;
    // } else {
    // list.add(nums2[j]);
    // j++;
    // }
    // }
    // while (i < nums1.length) {
    // list.add(nums1[i]);
    // i++;
    // }
    // while (j < nums2.length) {
    // list.add(nums2[j]);
    // j++;
    // }

    // if (list.size() % 2 == 0) {
    // int index = list.size() / 2;
    // return (double) (list.get(index) + list.get(index - 1)) / 2;
    // } else {
    // int index = (list.size() / 2);
    // return (double) list.get(index);
    // }
    // }

    /*
     * Better approach -
     * using count variable, not using temp array for storing both arrays
     */
    public static double findMedianSortedArrays(int[] a, int[] b) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; // total size
        // required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        // apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1)
                    ind1el = a[i];
                if (cnt == ind2)
                    ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1)
                    ind1el = b[j];
                if (cnt == ind2)
                    ind2el = b[j];
                cnt++;
                j++;
            }
        }

        // copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1)
                ind1el = a[i];
            if (cnt == ind2)
                ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1)
                ind1el = b[j];
            if (cnt == ind2)
                ind2el = b[j];
            cnt++;
            j++;
        }

        // Find the median:
        if (n % 2 == 1) {
            return (double) ind2el;
        }

        return (double) ((double) (ind1el + ind2el)) / 2.0;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 5, 9 };
        int nums2[] = { 2, 3, 6, 7 };
        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));
    }
}
