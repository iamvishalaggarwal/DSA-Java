package Leetcode75;

import java.util.ArrayList;

public class ReverseWords {
    // SC: O(2len)
    // TC: O(len)
    public String reverseWords(String s) {
        String[] strList = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String str : strList) {
            str = str.strip();
            if (!str.equals("")) {
                list.add(str);
            }
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }

        return String.join(" ", list);
    }
}
