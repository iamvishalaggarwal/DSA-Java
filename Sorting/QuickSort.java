public class QuickSort {

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= arr[pivot] && i <= high - 1) {
                i++;
            }
            while (arr[j] > arr[pivot] && j >= low + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, j, pivot);
        return j; // partition index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 8, 5, 4, 3 };
        System.out.print("Before sort = ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }
}
