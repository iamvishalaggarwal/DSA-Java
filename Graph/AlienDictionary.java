package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public void topoSort(Map<Integer, List<Integer>> map, List<Integer> res, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0 && map.containsKey(i))
                q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            res.add(curr);
            for (int neighbor : map.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }
    }

    public String findOrder(String[] words) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] seen = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                seen[c - 'a'] = true;
                map.putIfAbsent(c - 'a', new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    map.get(c1 - 'a').add(c2 - 'a');
                    indegree[c2 - 'a']++;
                    found = true;
                    break;
                }
            }
            if (!found && s1.length() > s2.length())
                return "";
        }

        List<Integer> result = new ArrayList<>();
        topoSort(map, result, indegree);
        int totalSeen = 0;
        for (boolean b : seen) {
            if (b)
                totalSeen++;
        }
        if (result.size() != totalSeen)
            return "";

        StringBuilder sb = new StringBuilder();
        String s = "";
        s.charAt(1);

        for (int i : result) {
            sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }
}
