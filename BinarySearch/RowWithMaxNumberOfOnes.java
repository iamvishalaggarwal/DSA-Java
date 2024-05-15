package BinarySearch;

public class RowWithMaxNumberOfOnes {

    public static int lowerBound(int arr[], int m) {
        int low = 0;
        int high = m - 1;
        int lb = -1;
        /*
         * we need to find the first occurence of 1 as array is sorted (using lower
         * bound concept),
         * so we can count the ones, => size of array - first Occurence
         */
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) { // since, target = 1
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    // considering n x m matrix
    /*
     * Binary search
     * TC: O(n) * O(log m)
     * SC: O(1)
     */
    public static int rowWithMaximumOnes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        for (int i = 0; i < n; i++) {
            int lb = lowerBound(matrix[i], m);
            int count = lb != -1 ? m - lb : 0;
            if (count > max) {
                maxRow = i;
                max = count;
            }
        }
        return maxRow;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 1 }, { 0, 0, 1 } };
        System.out.println("index of row with max ones = " + rowWithMaximumOnes(matrix));
    }
}
