package Leetcode75;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qRadiant = new LinkedList<>();
        Queue<Integer> qDire = new LinkedList<>();
        int n = senate.length();

        // make 2 q's for storing Radiant and dire, then compare
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                qRadiant.add(i);
            } else {
                qDire.add(i);
            }
        }

        // iterate until one party is gone
        while (!qRadiant.isEmpty() && !qDire.isEmpty()) {
            // grabs first index of both the parties
            int rId = qRadiant.remove();
            int dId = qDire.remove();

            if (rId < dId) {
                qRadiant.add(rId + n); // index which is small --> survives and add it into the last (as the table is
                                       // round)
            } else {
                qDire.add(dId + n);
            }
        }
        return qRadiant.size() > qDire.size() ? "Radiant" : "Dire";
    }
}
