package BinarySearch;

/*
Problem: Upper bound is defined as element in the array such that, arr[index] > x, 
where x is the target value
Note:: if element not found, then return the size of the array

Example:
Input: arr = {2,4,6,9,10} x = 9
o/p: 4
 */
public class UpperBound {
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

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5 };
        int target = 5;
        System.out.print("Upper bound index of array = " + findUpperBound(arr, target));
    }
}
