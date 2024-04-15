
/*
 * Problem:
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should return the array of nums such that the the array follows the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]

*/

public class RearrangeArrayElements {

    /*
     * Brute Force Approach - Storing positive and negative elements in different
     * array
     * 
     * TC: O(n) + O(n) = O(2n)
     * SC: O(n/2) + O(n/2) = O(n)
     */
    // public static int[] rearrangeArray(int[] arr) {
    // int n = arr.length;
    // int positive[] = new int[n / 2];
    // int negative[] = new int[n / 2];

    // int x = 0, y = 0;
    // for (int val : arr) {
    // if (val < 0) {
    // negative[x] = val;
    // x++;
    // } else {
    // positive[y] = val;
    // y++;
    // }
    // }
    // x = 0;
    // y = 0;
    // for (int i = 0; i < n; i++) {
    // if ((i + 1) % 2 != 0) {
    // arr[i] = positive[x];
    // x++;
    // } else {
    // arr[i] = negative[y];
    // y++;
    // }
    // }
    // return arr;
    // }

    /*
     * Optimal approach - Using temp array, storing positive number on even index
     * and negative number on odd index
     * 
     * TC: O(n)
     * SC: O(n)
     */
    public static int[] rearrangeArray(int arr[]) {
        int temp[] = new int[arr.length];

        int positive = 0;
        int negative = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[positive] = arr[i]; // even index == positive number
                positive += 2;
            } else {
                temp[negative] = arr[i];
                negative += 2;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

        System.out.println("After Rearrange negative and positive : ");
        for (int val : rearrangeArray(arr)) {
            System.out.print(val + " ");
        }
    }
}
