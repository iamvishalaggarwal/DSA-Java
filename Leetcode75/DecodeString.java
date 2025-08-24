package Leetcode75;

import java.util.Stack;

class Solution {
    // TC: (N), SC: O(M)
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // build number (handles multiple digits)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // push current state
                countStack.push(k);
                stringStack.push(curr);
                // reset for new section
                k = 0;
                curr = new StringBuilder();
            } else if (ch == ']') {
                // pop and build repeated string
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(curr);
                }
                curr = decoded;
            } else {
                // just a normal character
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
