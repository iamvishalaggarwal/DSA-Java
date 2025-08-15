package Leetcode75;

class Solution {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder();

        int count = 1;
        str.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    str.append(count);
                }
                str.append(chars[i]); // append diff one
                count = 1; // reset count
            }
        }
        if (count > 1) {
            str.append(count); // need to append last one as well
        }

        // inplace updating
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return str.length();
    }
}