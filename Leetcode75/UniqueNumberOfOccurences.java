package Leetcode75;

import java.util.*;

class Solution {
    // TC: O(N)
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() == map.values().size();
    }
}