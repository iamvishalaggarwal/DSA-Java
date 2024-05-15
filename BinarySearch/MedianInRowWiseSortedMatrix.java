package BinarySearch;

import java.util.ArrayList;

/*
 * Problem: 

Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
 
Example:
Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives 
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 */

public class MedianInRowWiseSortedMatrix {

    /*
     * Brute force - put all the numbers into a list, and then find the median value
     * TC: O(n*m) + O(n*m*log(n*m))
     * SC: O(n*m)
     */
    // public static int median(int matrix[][]) {
    // ArrayList<Integer> list = new ArrayList<>();
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[0].length; j++) {
    // list.add(matrix[i][j]);
    // }
    // }
    // list.sort(null);
    // return list.get(list.size() / 2);
    // }

    public static int upperBound(int arr[], int num) {
        // cause we need to find count of elements which are smaller than given number
        int low = 0;
        int high = arr.length - 1;
        int ub = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > num) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }

    public static int countSmallEquals(int[][] matrix, int num) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count += upperBound(matrix[i], num);
        }
        return count;
    }

    public static int median(int matrix[][]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        // find min-max for range
        for (int i = 0; i < m; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][n - 1]);
        }
        int low = min;
        int high = max;

        int req = (n * m) / 2; // median requirement
        while (low <= high) {
            int mid = (low + high) / 2;

            int smallEquals = countSmallEquals(matrix, mid);
            if (smallEquals <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 } };
        System.out.println("Median == " + median(matrix));
    }
}
