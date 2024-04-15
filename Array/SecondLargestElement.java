
import java.util.Scanner;

public class SecondLargestElement {

    /*
     * Approach 1: TC : O(N + N) = O(2*N)
     * public static int findSecondMax(int arr[]) {
     * int max = arr[0];
     * for (int i = 1; i < arr.length; i++) {
     * if (arr[i] > max) {
     * max = arr[i];
     * }
     * }
     * 
     * // for handle the case: when we don't have any second largest element
     * int secondMax = Integer.MIN_VALUE;
     * for (int i = 1; i < arr.length; i++) {
     * if (arr[i] > secondMax && arr[i] < max) {
     * secondMax = arr[i];
     * }
     * }
     * return secondMax;
     * }
     */

    // Approach 2: Optimal Solution - TC: O(N)
    public static int findSecondMax(int arr[]) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array = ");
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Second Largest Element = " + findSecondMax(arr));
        sc.close();
    }
}
