package Array;

public class RotateArrayByD {

    /*
     ** Brute Force Approach: TC(d * n)
     ** where d is no. of rotations and n is array length
     * public static void rotateByD(int arr[], int d) {
     * for (int j = 0; j < (d % arr.length); j++) {
     * int temp = arr[0];
     * for (int i = 1; i < arr.length; i++) {
     * arr[i - 1] = arr[i];
     * }
     * arr[arr.length - 1] = temp;
     * }
     * }
     */

    /*
     ** Approach 2:
     ** TC = O(d) + O(n - d) + O(d) = O(n + d)
     ** SC = O(d)
     * public static void rotateByD(int[] arr, int d) {
     * int n = arr.length;
     * if (n == 0) {
     * return;
     * }
     * d = d % n;
     * int temp[] = new int[d];
     * // storing into temp
     * for (int i = 0; i < d; i++) {
     * temp[i] = arr[i];
     * }
     * 
     * // shifting
     * for (int i = d; i < n; i++) {
     * arr[i - d] = arr[i];
     * }
     * 
     * // temp to main array
     * for (int i = n - d; i < n; i++) {
     * arr[i] = temp[i - (n - d)];
     * }
     * }
     */

    public static void reverse(int arr[], int i, int j) {
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    /*
     ** Approach 3: OPTIMAL SOLUTION (REVERSAL ALGO)
     ** TC = O(2n)
     ** SC = O(1)
     */
    public static void rotateByD(int arr[], int d) {
        d = d % arr.length;
        // reverse first d elements
        reverse(arr, 0, d - 1);
        // reverse n-d elements
        reverse(arr, d, arr.length - 1);
        // now, reverse whole array
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        rotateByD(arr, 2);

        System.out.print("After left rotate by D: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
