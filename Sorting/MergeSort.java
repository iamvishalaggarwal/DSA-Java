import java.util.ArrayList;

public class MergeSort {

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>(); // temp array for storing result after sorting

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if something left in left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if something left in right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfer element from arraylist (temp) to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) { // when there is only one elemennt left in sub-array
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 1, 1, 1, 1, 2, 3, 6, 2, 5, 1 };
        System.out.print("Before sort = ");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("\nAfter sort = ");
        printArray(arr);
    }
}
