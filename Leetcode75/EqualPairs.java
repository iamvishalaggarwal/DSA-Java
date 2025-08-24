package Leetcode75;

import java.util.ArrayList;

class Solution {
    public int equalPairs(int[][] grid) {
        ArrayList<String> rows = new ArrayList<>();
        ArrayList<String> cols = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            StringBuilder strRow = new StringBuilder();
            StringBuilder strCol = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                strRow.append(grid[i][j]);
                strRow.append(" ");
                strCol.append(grid[j][i]);
                strCol.append(" ");
            }
            rows.add(strRow.toString());
            cols.add(strCol.toString());
        }

        int count = 0;
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < cols.size(); j++) {
                if (rows.get(i).equals(cols.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
