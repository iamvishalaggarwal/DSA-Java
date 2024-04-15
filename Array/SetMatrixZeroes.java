
// import java.util.ArrayList;

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

    /*
     ** Better Approach - Keeping track of 0th row and col
     ** 
     ** TC: O(2 * m * n)
     ** SC: O(n + m)
     * public static void setZeroes(int[][] matrix) {
     * int m = matrix.length;
     * int n = matrix[0].length;
     * ArrayList<Integer> rows = new ArrayList<>();
     * ArrayList<Integer> cols = new ArrayList<>();
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * if (matrix[i][j] == 0) {
     * rows.add(i);
     * cols.add(j);
     * }
     * }
     * }
     * for (int row : rows) {
     * for (int col : cols) {
     * zeroMaker(matrix, row, col);
     * }
     * }
     * }
     */

    /*
     * Optimal approach -
     * TC: O(m*n)
     * SC: O(1)
     */
    public static void setZeroes(int[][] matrix) {
        // int row[] = new int[m] --> matrix[...][0]
        // int col[] = new int[n] --> matrix[0][...]

        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of cols
        int col0 = 1;

        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    /*
                     * Note: If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark
                     * the col0 variable with 0 instead of marking matrix[0][0] again
                     */

                    matrix[i][0] = 0; // row mark

                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0; // col mark
                    }
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        // We will not modify the 1st row and 1st column of the matrix here as the
        // modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is
        // dependent on that row and column.

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // step 3: Finally mark the 1st col & then 1st row:
        // If col0 = 0, we will change all the elements from the cell
        // (0,0) to (n-1, 0), to 0
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // If matrix[0][0] = 0, we will change all the elements from the cell
        // (0,1) to (0, m-1), to 0.
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
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
