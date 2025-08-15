package Leetcode75;

class Solution {
    public void moveZeroes(int[] arr) {
        int j = 0;

        // for finding the first 0th place
        while (j < arr.length && arr[j] != 0) {
            j++;
        }

        // now swap whenever we find zero at ith place
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }
}
