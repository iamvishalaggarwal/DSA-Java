
package BinarySearch;

/*
A conveyor belt has packages that must be shipped from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
 */

public class CapacityToShipPackages {

    public static int[] findSumAndMax(int arr[]) {
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += max;
        }
        int result[] = { max, sum };
        return result;
    }

    public static int findDaysReq(int weights[], int capacity) {
        int days = 1; // First day.
        int load = 0;
        int n = weights.length; // size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > capacity) {
                days += 1; // move to next day
                load = weights[i]; // load the weight.
            } else {
                // load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    /*
     * Using linear search
     */
    // public static int shipWithinDays(int[] weights, int days) {
    // int result[] = findSumAndMax(weights);
    // int maxElement = result[0]; // this == the minimum weight req for
    // shipping all packages
    // int sumOfElements = result[1]; // this == the max weight req --> to ship
    // all packages in 1 day
    // for (int i = maxElement; i <= sumOfElements; i++) {
    // int dayRequired = findDaysReq(weights, i);
    // if (dayRequired <= days) {
    // return i;
    // }
    // }
    // return -1; // never reach case
    // }

    /*
     * Using binary search
     */
    public static int shipWithinDays(int[] weights, int days) {
        int result[] = findSumAndMax(weights);
        // max element == the minimum weight req for shipping all packages
        // kyuki max weight lengy jabhi sare packages ship ho payngey (usse km le lia to
        // ni ho payngey)
        int low = result[0];
        // sum of all elements == the max weight req --> to ship all packages in 1
        // day i.e., if max weight le lia to sare ek din mai hi ship kr skte h
        int high = result[1];

        while (low <= high) {
            int mid = (low + high) / 2;
            int reqDays = findDaysReq(weights, mid);
            if (reqDays <= days) {
                high = mid - 1; // as we are finding for smallest capacity, so move towards left
            } else {
                low = mid + 1; // find largest, to increase the capacity
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println("Minimum capacity of ship = " + shipWithinDays(weights, days));
    }
}
