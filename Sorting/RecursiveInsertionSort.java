
public class RecursiveInsertionSort {

    public static void swap(int[] arr, int pos, int i) {
        int temp;
        temp = arr[pos];
        arr[pos] = arr[i];
        arr[i] = temp;
    }

    public static void insertionSort(int[] arr, int i, int n) {
        if (i == n)
            return;

        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        insertionSort(arr, i + 1, n);
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        System.out.print("Before sort = ");
        printArray(arr);

        insertionSort(arr, 0, arr.length - 1);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }

}