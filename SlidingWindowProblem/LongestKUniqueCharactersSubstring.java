package SlidingWindowProblem;

import java.util.HashMap;
import java.util.HashSet;

public class LongestKUniqueCharactersSubstring {

    /*
     * Brute force -
     * TC: O(n^2)
     * SC: O(3)
     */
    // public static int longestkSubstr(String str, int k) {
    // int maxLen = -1;
    // for (int i = 0; i < str.length(); i++) {
    // HashSet<Character> set = new HashSet<>();
    // for (int j = i; j < str.length(); j++) {
    // set.add(str.charAt(j));
    // if (set.size() == k) {
    // maxLen = Math.max(maxLen, j - i + 1);
    // } else if (set.size() > 3) {
    // break;
    // }
    // }
    // }
    // return maxLen;
    // }

    /*
     * Optimal -
     * TC: O(n)
     * SC: O(3) ~ O(1)
     */
    public static int longestkSubstr(String str, int k) {
        int l = 0, r = 0, maxLen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < str.length()) {
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);

            if (map.size() > k) {
                map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) - 1);
                if (map.get(str.charAt(l)) == 0) {
                    map.remove(str.charAt(l));
                }
                l++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println("Length of max substring = " + longestkSubstr(str, k));
    }
}
