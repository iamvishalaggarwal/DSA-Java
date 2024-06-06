package SlidingWindowProblem;

import java.util.HashMap;
import java.util.HashSet;

/*
Problem: Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/

public class LongestSubstringWithoutRepeatingChars {

    /*
     * Brute force - storing all char, by finding all subarrays
     * TC: O(n^2)
     * SC: O(n)
     */
    // public static int lengthOfLongestSubstring(String str) {
    // int maxLen = 0;
    // for (int i = 0; i < str.length(); i++) {
    // HashSet<Character> set = new HashSet<>();
    // for (int j = i; j < str.length(); j++) {
    // if (set.contains(str.charAt(j))) {
    // break; // as it contains same char
    // }
    // int len = j - i + 1;
    // maxLen = Math.max(maxLen, len);
    // set.add(str.charAt(j));
    // }
    // }
    // return maxLen;
    // }

    /*
     * Optimal - Using sliding window
     * TC: O(n)
     * SC: O(n)
     */
    public static int lengthOfLongestSubstring(String str) {
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while (r < str.length()) {
            if (map.containsKey(str.charAt(r))) {
                if (l <= map.get(str.charAt(r))) {
                    l = map.get(str.charAt(r)) + 1; // move 'l' if found repeated --> shrink
                }
            }
            map.put(str.charAt(r), r); // store all elements with index in map
            maxLen = Math.max(maxLen, r - l + 1);
            r = r + 1; // move 'r' if there is no repeat --> expand
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println("Length of longest substring = " + lengthOfLongestSubstring(str));
    }
}
