package BinarySearch;

public class CountOccurence {
    public static int findFirst(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first; // if element not found
    }

    public static int findEnd(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int end = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                end = mid;
                low = mid + 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return end; // if element not found
    }

    /*
     * Optimal Approach - using raw binary search
     * TC: O(2*logN)
     * SC: O(1)
     */
    public static int count(int[] arr, int x) {
        int first = findFirst(arr, x);
        if (first == -1) {
            return 0;
        }
        int end = findEnd(arr, x);
        return end - first + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int target = 9;
        System.out.println(target + " occurs " + count(arr, target) + " times in given array.");
    }
}
