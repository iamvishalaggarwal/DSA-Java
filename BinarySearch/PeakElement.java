package BinarySearch;

/*
 * Problem:
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
 */

public class PeakElement {

    public static int findMaxEleIndex(int[][] mat, int m, int n, int col) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length; // rows
        int n = mat[0].length; // cols

        int low = 0;
        int high = n - 1; // last col

        while (low <= high) {
            int mid = (low + high) / 2;
            int maxElementIndex = findMaxEleIndex(mat, m, n, mid);
            // since, max element among column, so it is greater than it's top and bottom
            // element
            int left = mid - 1 >= 0 ? mat[maxElementIndex][mid - 1] : -1;
            int right = mid + 1 < n ? mat[maxElementIndex][mid + 1] : -1;

            if (mat[maxElementIndex][mid] > left && mat[maxElementIndex][mid] > right) {
                int result[] = { maxElementIndex, mid };
                return result;
            } else if (mat[maxElementIndex][mid] < left) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        int result[] = { -1, -1 }; // dummy line
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 4 }, { 3, 2 } };
        for (int val : findPeakGrid(matrix)) {
            System.out.print(val + " ");
        }
    }
}
