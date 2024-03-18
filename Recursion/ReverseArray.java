import java.util.Scanner;

public class ReverseArray {

    // using while loop
    public static void reverseArrayUsingLoop(int[] arr, int len) {
        int i = 0;
        int j = len - 1;
        // swapping first and last element
        int tempForSwap;
        while (i < j) {
            tempForSwap = arr[i];
            arr[i] = arr[j];
            arr[j] = tempForSwap;
            i++;
            j--;
        }
    }

    // using recursion
    public static void reverseArrayUsingRecursion(int[] arr, int start, int end) {
        // swapping first and last element
        int tempForSwap;
        if (start > end) {
            return;
        }
        tempForSwap = arr[start];
        arr[start] = arr[end];
        arr[end] = tempForSwap;
        reverseArrayUsingRecursion(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array = ");
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Before Reverse = ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.print("\nAfter Reverse = ");
        // reverseArrayUsingLoop(arr, len);
        reverseArrayUsingRecursion(arr, 0, len - 1);
        for (int val : arr) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
