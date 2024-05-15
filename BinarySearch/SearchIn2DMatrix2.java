package BinarySearch;

/*
 * Problem:
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
 */

public class SearchIn2DMatrix2 {

    // public boolean isFound(int[] arr, int target) {
    // int low = 0;
    // int high = arr.length - 1;
    // while (low <= high) {
    // int mid = (low + high) / 2;
    // if (arr[mid] == target) {
    // return true;
    // } else if (target < arr[mid]) {
    // high = mid - 1;
    // } else {
    // low = mid + 1;
    // }
    // }
    // return false;
    // }

    /*
     * Better Approach - binary search on each row
     * TC: O(N*logN)
     * SC: O(1)
     */
    // public boolean searchMatrix(int[][] matrix, int target) {
    // int m = matrix.length;
    // int n = matrix[0].length;
    // for (int i = 0; i < m; i++) {
    // if (isFound(matrix[i], target)) {
    // return true;
    // }
    // }
    // return false;
    // }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1; // top - rightmost column
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println("Element present = " + searchMatrix(matrix, target));
    }

}
