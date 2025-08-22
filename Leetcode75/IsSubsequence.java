package Leetcode75;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // two pointer, i = s[0] and j = t[0]
        int i = 0, j = 0;

        // TC: O(len(t))
        while (j < t.length()) {
            if (i == s.length()) {
                return true;
            } else if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else
                j++;
        }
        return i == s.length(); // for the test case, when the last char of 's' present at last index of 't', so
                                // that while loop exist then we need to check at the end
    }
}
