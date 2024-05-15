package BinarySearch;

/*
Problem: Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

Example:
Input: ‘n’ = 7
Output: 2
Explanation:
The square root of the number 7 lies between 2 and 3, so the floor value is 2.
*/

public class SqrtOfNumberUsingBS {

    /*
     * Using linear loop - searching with each number, for finding required maxmimum
     * number whose square is equal to or less than given number
     * 
     * TC: O(n)
     * SC: O(1)
     */
    // public static int findSqrt(int num) {
    // int sqrt = 0;
    // for (int i = 1; i <= num; i++) {
    // if (i * i <= num) {
    // sqrt = i;
    // } else {
    // break;
    // }
    // }
    // return sqrt;
    // }

    /*
     * Using Binary search -
     * we are using BS as we have range for the result here (1 to N)
     * whenever we have range, or we need to find max or min number, we can use BS
     * 
     * TC: O(logN)
     * SC: O(1)
     */
    public static int findSqrt(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= n) {
                low = (int) (mid + 1);
            } else {
                high = (int) mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int num = 64;
        System.out.println("Square root of " + num + " = " + findSqrt(num));
    }
}
