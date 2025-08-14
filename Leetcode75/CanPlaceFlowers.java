package Leetcode75;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // TC: O(len)
        // SC: O(1)
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == len - 1) ? 0 : flowerbed[i + 1];

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1; // Plant flower
                    n--;
                }
            }
        }
        return n == 0;
    }
}
