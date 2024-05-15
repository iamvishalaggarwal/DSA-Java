package BinarySearch;

public class FirstAndLastOccurence {
    public static int findLowerBound(int arr[], int target) {
        int lb = -1; // if no lower bound found
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

    public static int findUpperBound(int arr[], int target) {
        int ub = arr.length; // if no Upper bound found
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                ub = mid; // this may be the Upper bound
                // but, we need to found the smallest, so we move towards left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }

    /*
     * Optimal - using LB and UB
     * TC: O(2*logN)
     * SC: O(1)
     */
    public static int[] getFirstAndLastOccurence(int arr[], int target) {
        int firstOccurence = findLowerBound(arr, target);
        // if the found lower bound is not equal to the target element, then we also
        // need to return {-1, -1}
        if (firstOccurence == -1 || arr[firstOccurence] != target) // if there is no
        // first occurence, then there will be
        // no last occurence as well
        {
            int result[] = { -1, -1 };
            return result;
        }
        int lastOccurence = findUpperBound(arr, target) - 1;
        int result[] = { firstOccurence, lastOccurence };
        return result;
    }

    /*
     * Brute force - Using linear search
     * TC: O(n)
     * SC: O(1)
     */
    // public static int[] getFirstAndLastOccurence(int arr[], int target) {
    // int first = -1;
    // int last = -1;
    // for (int i = 0; i < arr.length; i++) {
    // if (target == arr[i]) {
    // if (first == -1) {
    // first = i;
    // }
    // last = i;
    // }
    // }
    // int result[] = { first, last };
    // return result;
    // }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.print("first and last occurence of element: ");
        int result[] = getFirstAndLastOccurence(arr, target);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
