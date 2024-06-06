package SlidingWindowProblem;

import java.util.HashMap;
import java.util.Map.Entry;

public class LongestRepeatingCharacterReplacement {

    /*
     * Brute force -
     * TC: O(n*n)
     * SC: O(26)
     */
    // public static int characterReplacement(String str, int k) {
    // int maxLen = 0;
    // for (int i = 0; i < str.length(); i++) {
    // HashMap<Character, Integer> map = new HashMap<>();
    // int maxFrequency = 0;
    // for (int j = i; j < str.length(); j++) {
    // if (map.containsKey(str.charAt(j))) {
    // map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
    // } else {
    // map.put(str.charAt(j), 1);
    // }

    // maxFrequency = Math.max(maxFrequency, map.get(str.charAt(j)));

    // // changes = len - maxFrequency
    // int changes = (j - i + 1) - maxFrequency;
    // if (changes <= k) {
    // maxLen = Math.max(maxLen, j - i + 1);
    // } else
    // break;
    // }
    // }
    // return maxLen;
    // }

    /*
     * Better Approach - using sliding window
     * TC: O((n + n)*26)
     * SC: O(26)
     */
    // public static int characterReplacement(String str, int k) {
    // int l = 0, r = 0, maxLen = 0, maxFrequency = 0;
    // HashMap<Character, Integer> map = new HashMap<>();
    // while (r < str.length()) {
    // // storing data in map with frequency
    // if (map.containsKey(str.charAt(r))) {
    // map.put(str.charAt(r), map.get(str.charAt(r)) + 1);
    // } else {
    // map.put(str.charAt(r), 1);
    // }

    // maxFrequency = Math.max(maxFrequency, map.get(str.charAt(r)));

    // // shrink window, when we have more changes than limit (k)
    // // changes = len - maxFrequency
    // while ((r - l + 1) - maxFrequency > k) {
    // map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
    // maxFrequency = 0;
    // // find maxfrequency again in whole map
    // // after reducing frequency of one element by 1
    // for (Entry<Character, Integer> ch : map.entrySet()) {
    // maxFrequency = Math.max(maxFrequency, ch.getValue());
    // }
    // l++;
    // }
    // // updating max len
    // if ((r - l + 1) - maxFrequency <= k) {
    // maxLen = Math.max(maxLen, (r - l + 1));
    // }
    // r++;
    // }
    // return maxLen;
    // }

    /*
     * Optimised -
     * - remove the max frequency finding again
     * - remove the inner while loop
     * - remove hash map, and used array
     */
    public static int characterReplacement(String str, int k) {
        int l = 0, r = 0, maxLen = 0, maxFrequency = 0;
        int arr[] = new int[26];

        while (r < str.length()) {
            // storing data in map with frequency
            arr[str.charAt(r) - 'A'] += 1;

            maxFrequency = Math.max(maxFrequency, arr[str.charAt(r) - 'A']);

            // shrink window, when we have more changes than limit (k)
            // changes = len - maxFrequency
            if ((r - l + 1) - maxFrequency > k) {
                arr[str.charAt(l) - 'A'] -= 1;
                l++;
            }

            // updating max len
            if ((r - l + 1) - maxFrequency <= k) {
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        System.out.println("Longest substring = " + characterReplacement(str, 1));
    }
}
