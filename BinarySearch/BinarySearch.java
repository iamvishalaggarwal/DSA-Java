package BinarySearch;

public class BinarySearch {

    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // if element not found
    }

    public static void main(String[] args) {
        int arr[] = { -1, 2, 4, 6, 10, 23 };
        int target = 2;
        System.out.println("Element present at " + binarySearch(arr, target) + " index.");
    }
}
