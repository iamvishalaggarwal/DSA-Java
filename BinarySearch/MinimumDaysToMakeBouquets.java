package BinarySearch;

/**
 * MinimumDaysToMakeBouquets
 * You are given an integer array bloomDay, an integer m and an integer k.
 * 
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 * 
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let us see what happened in the first three days. x means flower
 * bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _] // we can only make one bouquet.
 * After day 2: [x, _, _, _, x] // we can only make two bouquets.
 * After day 3: [x, _, x, _, x] // we can make 3 bouquets. The answer is 3.
 */
public class MinimumDaysToMakeBouquets {

    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int result[] = { min, max };
        return result;
    }

    public static int findNumberOfBouquets(int bloomDay[], int day, int numberOfFlowers) {
        int count = 0;
        int numberOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                count++;
            } else {
                if (count >= numberOfFlowers) {
                    numberOfBouquets += count / numberOfFlowers;
                }
                count = 0;
            }
        }

        if (count >= numberOfFlowers) {
            numberOfBouquets += count / numberOfFlowers;
        }
        return numberOfBouquets;
    }

    /*
     * Using linear search
     * TC: O(n) * O(high - low + 1)
     */
    // public static int minDays(int[] bloomDay, int m, int k) {
    // if (m * k > bloomDay.length) {
    // return -1;
    // }

    // int[] minMax = findMinMax(bloomDay);

    // int min = minMax[0]; // minimum day at which flower bloom
    // int max = minMax[1]; // maximum day at which flower bloom
    // for (int i = min; i <= max; i++) {
    // int numberOfBouquets = findNumberOfBouquets(bloomDay, i, k);
    // if (numberOfBouquets >= m) {
    // return i;
    // }
    // }
    // return -1; // if no bouquet found
    // }

    /*
     * Using binary search
     * TC: O(n) * O(log((high - low + 1)))
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        int[] minMax = findMinMax(bloomDay);

        int low = minMax[0]; // minimum day at which flower bloom
        int high = minMax[1]; // maximum day at which flower bloom
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfBouquets = findNumberOfBouquets(bloomDay, mid, k);
            if (numberOfBouquets >= m) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans != high ? ans : -1; // if no bouquet found
    }

    public static void main(String[] args) {
        // int bloomDay[] = { 1000000000, 1000000000 }; // number of days array
        int bloomDay[] = { 1, 10, 3, 10, 2 }; // number of days array
        int m = 5; // number of bouquets
        int k = 1; // number of adjacent flowers
        System.out.println("Minimum number of days = " + minDays(bloomDay, m, k));

    }
}