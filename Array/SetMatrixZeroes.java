package Array;

import java.util.ArrayList;

public class SetMatrixZeroes {

    public static void zeroMaker(int matrix[][], int row, int col) {
        int m = matrix.length; // m -> rows
        int n = matrix[0].length; // n -> cols
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = 0; // for bruteforce --> matrix[i][col] = -1
        }

        for (int i = 0; i < n; i++) {
            if (matrix[row][i] != 0)
                matrix[row][i] = 0; // for bruteforce --> matrix[row][i] = -1
        }
    }

    /*
     ** Brute Force: Finding all zeroes and converting their respective row and cols
     ** into 'Integer.MIN_VALUE'
     ** as if we convert it to '0' then it will make all matrix as null matrix, (we
     ** need to preserve 0th locations)
     ** once, we make all req rows and cols, then we will iterate over the matrix and
     ** make them zero as well.
     ** 
     ** TC: O(n*m) + O(n+m) + O(n*m) ~ O(n^3)
     ** SC: O(1)
     * 
     * public static void setZeroes(int[][] matrix) {
     * int m = matrix.length;
     * int n = matrix[0].length;
     * boolean isZeroPresent = false;
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * if (matrix[i][j] == 0) {
     * // logic
     * zeroMaker(matrix, i, j);
     * isZeroPresent = true;
     * }
     * }
     * }
     * 
     * if (!isZeroPresent) {
     * return;
     * }
     * 
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * if (matrix[i][j] == Integer.MIN_VALUE) {
     * // logic
     * matrix[i][j] = 0;
     * }
     * }
     * }
     * }
     */

    /**
     * Better Approach - Keeping track of 0th row and col
     * 
     * TC: O(2 * m * n)
     * SC: O(n + m)
     */

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int col : cols) {
                zeroMaker(matrix, row, col);
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Before making zeroes = ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        setZeroes(matrix);
        System.out.println("After making zeroes = ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
