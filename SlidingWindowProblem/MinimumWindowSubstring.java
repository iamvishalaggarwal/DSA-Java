package SlidingWindowProblem;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int m = 0;
        int sIndex = -1; // starting index of min substring
        int hashMap[] = new int[256]; // as we have 256 characters
        // pre-storing 't' string characters in hashmap
        while (m < t.length()) {
            hashMap[t.charAt(m)]++;
            m++;
        }

        while (r < s.length()) {
            if (hashMap[s.charAt(r)] > 0)
                count++;
            hashMap[s.charAt(r)]--;
            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                hashMap[s.charAt(l)]++;
                if (hashMap[s.charAt(l)] > 0)
                    count--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum substring = " + minWindow(str, t));
    }
}
