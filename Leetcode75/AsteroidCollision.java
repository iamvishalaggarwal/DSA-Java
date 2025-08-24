package Leetcode75;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // TC: O(2N), SC: O(N)
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.empty() && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(asteroids[i])) {
                    st.pop();
                }
                if (!st.empty() && st.peek() > 0 && Math.abs(st.peek()) == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.empty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
