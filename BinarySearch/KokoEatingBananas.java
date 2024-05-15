package BinarySearch;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Example :

Input: piles = [3,6,7,11], h = 8
Output: 4
*/

public class KokoEatingBananas {

    public static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static int findRequiredTime(int piles[], int hourlyBananas) {
        int totalTime = 0;
        for (int val : piles) {
            totalTime += Math.ceil((double) (val) / (double) (hourlyBananas));
        }
        return totalTime;
    }

    /*
     * Brute force: Using linear search
     * TC: O(N) * O(maxElementInArray)
     * SC: O(1)
     */
    // public static int minEatingSpeed(int[] piles, int h) {
    // // range should be from 1 to maxElement present in array
    // // [3,6,7,11] --> wo 3 banana kitni der mai khaygi, 6 kitni der mai khaygi
    // and
    // // so on.... agr wo 1 hour mai 1 banana khati hai, 2 khati hai or so on...
    // // we need to find 'k' -> speed of koko of eating bananas
    // for (int i = 1; i <= maxElement(piles); i++) {
    // int requiredTime = findRequiredTime(piles, i);
    // if (requiredTime <= h) {
    // return i; // minimum number of bananas
    // }
    // }
    // return -1; // never reach
    // }

    /*
     * Optimal : Using binary search concept
     * TC: O(N) * O(log(maxElementInArray))
     * SC: O(1)
     */
    public static int minEatingSpeed(int[] piles, int h) {
        // defining range from 1 to max element in array
        // as there is a range, so we can apply BS
        int low = 1;
        int high = maxElement(piles);
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredTime = findRequiredTime(piles, mid);
            if (requiredTime <= h) {
                ans = Math.min(ans, mid); // may be our answer, but we move towards left for finding minimum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int hours = 8;
        System.out.println("Minimum number of bananas koko can eat = " + minEatingSpeed(piles, hours));
    }
}
