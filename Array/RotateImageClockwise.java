
/*
Problem: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/

public class RotateImageClockwise {

    // Brute Force Approach - Using temp array
    // TC: O(n^2)
    // SC: O(n^2)
    // public static void rotate(int[][] matrix) {
    // int n = matrix.length; // square matrix

    // int temp[][] = new int[n][n];
    // int k = n - 1;

    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // temp[j][k] = matrix[i][j];
    // }
    // k--;
    // }

    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // matrix[i][j] = temp[i][j];
    // }
    // }
    // }

    public static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void reverse(int[][] matrix, int i) {
        int n = matrix.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;

            start++;
            end--;
        }
    }

    /*
     * Optimal Approach -
     * 1) Transpose the matrix
     * 2) reverse each row of matrix
     * 
     * TC: (n^2)
     * SC: O(1)
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // step 1: transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap matrix[i][j] --> matrix[j][i]
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            // reverse each row of matrix
            reverse(matrix, i);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Before = ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println("After = ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
