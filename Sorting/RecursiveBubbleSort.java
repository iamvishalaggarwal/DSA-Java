/**
 * BubbleSort
 * 
 * Rule: push the max to the end by swapping adjacent element
 * TC: O(n^2) --> for worst and avg case,
 * but O(n) for best case [i.e., already sorted array]
 */
public class RecursiveBubbleSort {

    public static void swap(int[] arr, int pos, int i) {
        int temp;
        temp = arr[pos];
        arr[pos] = arr[i];
        arr[i] = temp;
    }

    public static void bubbleSort(int[] arr, int n) {

        if (n == 1)
            return;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 45, 216, 198, 795, 484, 650, 590, 431, 705, 316, 557, 189, 652, 606, 153, 829, 813, 367, 658,
                961 };
        System.out.print("Before sort = ");
        printArray(arr);

        bubbleSort(arr, arr.length - 1);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }

}