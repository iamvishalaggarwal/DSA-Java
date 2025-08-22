package Leetcode75;

// public class MaxVowelsInSubstring {
//     private int getVowelCount(String str) {
//         int count = 0;
//         for (int i = 0; i < str.length(); i++) {
//             char ch = str.charAt(i);
//             if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//                 count++;
//             }
//         }
//         return count;
//     }

//     // TC: O((N-K)*K) ~ O(N^2)
//     public int maxVowels(String s, int k) {
//         int len = s.length();
//         int result = 0;

//         for (int i = 0; i <= len - k; i++) {
//             String subStr = s.substring(i, i + k);
//             int count = getVowelCount(subStr);
//             result = Math.max(count, result);
//         }

//         return result;
//     }
// }

class Solution {
    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    private int getVowelCount(String str, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    public int maxVowels(String s, int k) {
        int len = s.length();
        int count = getVowelCount(s, k);
        int result = count;

        for (int i = k; i < len; i++) {
            char newCh = s.charAt(i);
            char releaseCh = s.charAt(i - k);
            if (isVowel(newCh))
                count++;
            if (isVowel(releaseCh))
                count--;

            result = Math.max(count, result);
        }
        return result;
    }
}