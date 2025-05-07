package Graph;

import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String beginWord,
            String endWord,
            String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        q.add(new ArrayList<>(Arrays.asList(beginWord)));
        set.remove(beginWord);

        boolean foundEnd = false;

        while (!q.isEmpty() && !foundEnd) {
            int size = q.size();
            List<String> listOfLastWords = new ArrayList<>();

            for (int x = 0; x < size; x++) {
                List<String> listOfWords = q.remove();
                String lastWord = listOfWords.getLast();

                for (int i = 0; i < lastWord.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] replacedCharArray = lastWord.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);
                        if (set.contains(replacedWord)) {
                            ArrayList<String> newPath = new ArrayList<>(listOfWords);
                            newPath.add(replacedWord);
                            if (replacedWord.equals(endWord)) {
                                result.add(newPath);
                                foundEnd = true;
                            } else {
                                q.add(newPath);
                                listOfLastWords.add(replacedWord);
                            }
                        }
                    }
                }

            }
            // remove those whose used in building new sequence from set,
            // once the level is done - as it will be use by the similar level sequence
            for (String word : listOfLastWords) {
                set.remove(word);
            }
        }
        return result;
    }
}