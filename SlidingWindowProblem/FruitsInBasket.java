package SlidingWindowProblem;

import java.util.HashMap;
import java.util.HashSet;

public class FruitsInBasket {

    /*
     * Brute force:
     * TC: O(n^2)
     * SC: O(3)
     */
    // public static int totalFruits(int[] fruits) {
    // // max length subarray with atmost 2 types of numbers
    // int maxLen = 0;
    // for (int i = 0; i < fruits.length; i++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int j = i; j < fruits.length; j++) {
    // set.add(fruits[j]);
    // if (set.size() <= 2) {
    // maxLen = Math.max(maxLen, j - i + 1);
    // } else {
    // break;
    // }
    // }
    // }
    // return maxLen;
    // }

    /*
     * Better - store the frequency and using sliding window
     * TC: O(N + N)
     * SC: O(3)
     */
    // public static int totalFruits(int[] fruits) {
    // int l = 0, r = 0;
    // int maxLen = 0;
    // HashMap<Integer, Integer> map = new HashMap<>();

    // while (r < fruits.length) {
    // // storing 'number' and its frequency
    // if (map.containsKey(fruits[r])) {
    // map.put(fruits[r], map.get(fruits[r]) + 1);
    // } else {
    // map.put(fruits[r], 1);
    // }

    // if (map.size() > 2) {
    // // move 'l' and decrease the frequency
    // // if frequency reaches '0', then remove that key
    // while (map.size() > 2) {
    // map.put(fruits[l], map.get(fruits[l]) - 1);
    // if (map.get(fruits[l]) == 0) {
    // map.remove(fruits[l]);
    // }
    // l++;
    // }
    // } else {
    // maxLen = Math.max(maxLen, r - l + 1);
    // }
    // r++;
    // }
    // return maxLen;
    // }

    /*
     * Optimal - store the frequency and using sliding window
     * TC: O(N)
     * SC: O(3)
     */
    public static int totalFruits(int[] fruits) {
        int l = 0, r = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            // storing 'number' and its frequency
            if (map.containsKey(fruits[r])) {
                map.put(fruits[r], map.get(fruits[r]) + 1);
            } else {
                map.put(fruits[r], 1);
            }

            if (map.size() > 2) {
                // move 'l' and decrease the frequency
                // if frequency reaches '0', then remove that key
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 2, 9, 1, 9, 11, 8, 9, 6, 6, 6, 1 };
        System.out.println("Maximum fruits in 2 basket = " + totalFruits(arr));
    }
}
