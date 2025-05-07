package Graph;

import java.util.*;

class Pair {
    String first; // word
    int second; // level

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Using BFS - as we need to find the shortest transformation sequence
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(); // for storing non-visited words
        // initially, all words are not visited, so add all into set
        for (String word : wordList) {
            set.add(word);
        }

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord); // remove if exist

        while (!q.isEmpty()) {
            Pair p = q.remove();
            String word = p.first;
            int level = p.second;
            // the moment, when we find the end word, we need to remove the level value
            if (word.equals(endWord)) {
                return level;
            }
            for (int i = 0; i < word.length(); i++) {
                // replacing every letter of current word with a to z, and check if it exist in
                // wordList, if exist add into queue (as it is possible combination)
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    // if exist in the set
                    if (set.contains(replacedWord)) {
                        // jaise hi hume wo word milega to hum use non-visited set mai se remove kr
                        // denge, so that dobara use na kr ske kisi combination mai
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}