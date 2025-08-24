package Leetcode75;

import java.util.Stack;

class Solution1 {
    public int findIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                return i;
            }
        }
        return -1;
    }

    // TC: O(n^2), SC: O(1)
    public String removeStars(String s) {
        int idx = findIndex(s);
        while (idx != -1) {
            s = s.substring(0, idx - 1) + s.substring(idx + 1, s.length());
            idx = findIndex(s);
        }
        return s;
    }
}

class Solution2 {
    // TC: O(N), SC: O(N)
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        String str = new String();
        while (!st.isEmpty()) {
            str = st.pop() + str;
        }
        return str;
    }
}

class Solution3 {
    // MOST OPTIMIZED
    // TC: O(N), SC: O(1)
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}