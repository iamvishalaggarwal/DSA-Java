package SlidingWindowProblem;

public class NumberofSubstringsContainingAllThreeCharacters {

    // public static int numberOfSubstrings(String str) {
    // int count = 0;
    // for (int i = 0; i < str.length(); i++) {
    // String subString = "";
    // for (int j = i; j < str.length(); j++) {
    // subString = subString + str.charAt(j);
    // if (subString.contains("a") && subString.contains("b") &&
    // subString.contains("c")) {
    // // as whenever we find valid substring, then the substring after that will
    // also
    // // be valid
    // count = count + (str.length() - j);
    // break;
    // }
    // }
    // }
    // return count;
    // }

    /*
     * Intution - consider that with every char of string, there is a substring
     * which ends
     * So, what we do is we store the index of a, b, c and when we have all three
     * then we find the minimum, to find the min window (from right to left), then
     * add 1 to the min index
     * 
     * eg: "bbacba"
     * suppose, r = 3,
     * where,
     * a = 2
     * b = 1
     * c = 3
     * now we find min (i.e., b) which is like a min window == bac
     * so the substring generate till r = 3 is index(b) + 1 == 2
     * 
     * TC: O(n)
     * SC: O(1) [as the space is only 3 size]
     */
    public static int numberOfSubstrings(String str) {
        int lastSeenChars[] = { -1, -1, -1 }; // denotes occurence of a,b,c
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            // if (str.charAt(i) == 'a')
            // lastSeenChars[0] = i;
            // else if (str.charAt(i) == 'b')
            // lastSeenChars[1] = i;
            // else if (str.charAt(i) == 'c')
            // lastSeenChars[2] = i;
            lastSeenChars[str.charAt(i) - 'a'] = i;
            if (lastSeenChars[0] != -1 && lastSeenChars[1] != -1 && lastSeenChars[2] != -1) {
                int minIndex = Math.min(lastSeenChars[0], (Math.min(lastSeenChars[1], lastSeenChars[2])));
                count = count + minIndex + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aaacb";
        System.out.println("Number of substrings = " + numberOfSubstrings(str));
    }
}
