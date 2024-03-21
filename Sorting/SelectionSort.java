/**
 * SelectionSort
 * 
 * Rule: select minimum and swap
 * 
 * TC: O(n^2) --> for worst, best and avg case
 */
public class SelectionSort {

    public static void swap(int[] arr, int pos, int i) {
        int temp;
        temp = arr[pos];
        arr[pos] = arr[i];
        arr[i] = temp;
    }

    public static void selectionSort(int[] arr) {
        int pos;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            swap(arr, pos, i);
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 6, 2, 5, 1 };
        System.out.print("Before sort = ");
        printArray(arr);

        selectionSort(arr);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }

}