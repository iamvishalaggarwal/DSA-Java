package Array;

import java.util.Arrays;
import java.util.Scanner;

public class LargestElementInArray {

    // optimal solution
    // TC: O(n) and SC: O(1)
    public static int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Brute Force approach
    // TC: O(n * log n)
    // SC: O(1)
    public static int findMax(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array = ");
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println("Max Element = " + maxElement(arr));
        System.out.println("Max Element = " + findMax(arr));
        sc.close();
    }
}
