/**
 * BubbleSort
 * 
 * Rule: push the max to the end by swapping adjacent element
 * TC: O(n^2) --> for worst and avg case,
 * but O(n) for best case [i.e., already sorted array]
 */
public class BubbleSort {

    public static void swap(int[] arr, int pos, int i) {
        int temp;
        temp = arr[pos];
        arr[pos] = arr[i];
        arr[i] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    didSwap = 1;
                }
            }
            if (didSwap == 0) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 41, 467, 334, 500, 169, 724, 478, 358, 962, 464 };
        System.out.print("Before sort = ");
        printArray(arr);

        bubbleSort(arr);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }

}