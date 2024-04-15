
// Problem: rotate the array to the right
/*
Input: nums = [1,2,3,4,5,6,7], d = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

public class RightRotateArrayByD {

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
     ** Approach: OPTIMAL SOLUTION (REVERSAL ALGO)
     ** TC = O(2n)
     ** SC = O(1)
     */
    public static void rotate(int[] arr, int d) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        d = d % n;
        // first n-d-1 elements
        reverse(arr, 0, n - d - 1);
        // last d elements
        reverse(arr, n - d, n - 1);
        // now, whole array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);

        System.out.print("After right rotate by D: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
