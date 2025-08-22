package Leetcode75;

public class ContainerWithMostArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;

        while (i < j) {
            int waterLevel = Math.min(height[i], height[j]);
            int totalWater = waterLevel * (j - i);
            max = Math.max(max, totalWater);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return max;
    }
}
