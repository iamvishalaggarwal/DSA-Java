/**
 * InsertionSort
 * 
 * Rule: takes an element and place it in its correct order
 * 
 * TC: O(n^2) --> for worst, best and avg case
 */
public class InsertionSort {

    public static void swap(int[] arr, int pos, int i) {
        int temp;
        temp = arr[pos];
        arr[pos] = arr[i];
        arr[i] = temp;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
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

        insertionSort(arr);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }

}