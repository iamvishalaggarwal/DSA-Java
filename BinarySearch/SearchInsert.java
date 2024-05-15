package BinarySearch;

public class SearchInsert {
    public static int findLowerBound(int arr[], int target) {
        int lb = arr.length; // if no lower bound found
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                lb = mid; // this may be the lower bound
                // but, we need to found the smallest, so we move towards left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 10, 23, 27, 30 };
        int target = 25;
        // this is similar to lower bound, as the element can be >= target value
        System.out.print("Element found at or inserted at = " + findLowerBound(arr, target));
    }
}
