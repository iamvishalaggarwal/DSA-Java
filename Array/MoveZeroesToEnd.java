package Array;

/**
 * Example:
 * Input: 1, 0, 2, 3, 0, 4, 0, 1
 * Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
 * Explanation: All the zeros are moved to the end and non-negative integers are
 * moved to front by maintaining order
 */

public class MoveZeroesToEnd {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
     ** Brute Force Approach: TC = O(n) + O(x) + O(n) = O(2n + x)
     ** SC = O(n)
     * public static void movingZeroes(int arr[]) {
     * int n = arr.length;
     * int temp[] = new int[n];
     * 
     * int count = 0, j = 0;
     * for (int i = 0; i < n; i++) {
     * if (arr[i] == 0) {
     * count++;
     * } else {
     * temp[j] = arr[i];
     * j++;
     * }
     * }
     * // transferring zeroes to temp
     * for (int i = 0; i < count; i++) {
     * temp[j] = 0;
     * j++;
     * }
     * // move temp to original array
     * for (int i = 0; i < n; i++) {
     * arr[i] = temp[i];
     * }
     * }
     */

    /*
     ** Optimal Approach: TC = O(n)
     ** SC = O(1)
     */
    public static void movingZeroes(int arr[]) {
        int j = 0;

        // for finding the first 0th place
        while (j < arr.length && arr[j] != 0) {
            j++;
        }

        // now swap whenever we find zero at ith place
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };

        movingZeroes(arr);

        System.out.print("After moving zeroes to end = ");
        printArray(arr);
    }
}
