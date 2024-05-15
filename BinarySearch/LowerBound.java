package BinarySearch;

/*
Problem: Lower bound is defined as element in the array such that, arr[index] >= x, 
where x is the target value
Note:: if element not found, then return the size of the array

Example:
Input: arr = {2,4,6,9,10} x = 9
o/p: 3
 */
public class LowerBound {

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
        System.out.print("Lower bound index of array = " + findLowerBound(arr, target));
    }

}
