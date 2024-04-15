
import java.util.Scanner;

/**
 * Problem:
 * check whether the given array is sorted in the non-decreasing order or not
 */

public class SortedArrayOrNot {

    // TC: O(N)
    public static String isSortedArray(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array = ");
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("is Array Sorted ?\n" + isSortedArray(arr));
        sc.close();
    }
}
