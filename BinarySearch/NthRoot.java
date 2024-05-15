package BinarySearch;

/*
Problem: 
You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.
 
Example:
Input: ‘n’ = 3, ‘m’ = 27

Output: 3

Explanation: 
3rd Root of 27 is 3, as (3)^3 equals 27.

*/

public class NthRoot {

    /*
     * Binary search concept -
     * TC: O(logN) * O(logN)
     * SC: O(1)
     */
    public static int nthRoot(int n, int base) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            long val = (long) Math.pow(mid, base); // Math.pow() takes O(logN) times
            if (val == n) {
                return mid; // return if found
            } else if (val < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // if no root found, return -1
    }

    public static void main(String[] args) {
        int n = 27;
        int base = 3;
        System.out.println("nth root = " + nthRoot(n, base));
    }
}
