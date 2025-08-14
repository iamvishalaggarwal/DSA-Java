package Leetcode75;

// TC: O(n+m)
public class GCDofStrings {
    // division method of finding GCD
    private int gcd(int a, int b) {
        while (b % a != 0) {
            int rem = b % a;
            b = a;
            a = rem;
        }
        return a;
    }

    public String gcdOfStrings(String str1, String str2) {
        // let's say 'x' is the result which is the gcd of str1 and str2, now we can say
        // str1 and str2 are comprised of 'x' (ie, when we add multiple times 'x')

        // TC: O(m+n) ie, len(str1) + len(str2)

        // since, str1 (should comprised of x) and str2 (should comprised of x), so for
        // a check we should check str1 + str2 == str2 + str1
        // e.g: LEET + CODE (in this case gcd doesn't exist, as there is no 'x')
        if ((str1 + str2).equals(str2 + str1)) {
            int a = str1.length();
            int b = str2.length();
            int gcd = gcd(a, b);
            // now we need to find the max length of x, so that we can use multiple 'x' to
            // make str1 and str2
            // we can also make min len of 'x' but according to ques we need largest
            return str1.substring(0, gcd);
        } else {
            return "";
        }
    }
}
