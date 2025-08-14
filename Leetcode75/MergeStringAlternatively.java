package Leetcode75;

public class MergeStringAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int min_len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min_len; i++) {
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
        }

        if (str.length() < word1.length() + word2.length()) {
            if (word1.length() > word2.length()) {
                String req = word1.substring(word2.length(), word1.length());
                str.append(req);
            } else {
                String req = word2.substring(word1.length(), word2.length());
                str.append(req);
            }
        }

        return str.toString();
    }
}
