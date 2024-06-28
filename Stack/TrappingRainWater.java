package Stack;

public class TrappingRainWater {

    /*
     * Intution -
     * find: water[i] = min(maxL, maxR) - height of building = min(maxL, maxR) -
     * arr[i]
     * where maxL is max value in left side
     * and maxR is max value in right side
     * total water = sum of all water[i]
     */
    public static int findMaxInLeft(int height[], int index) {
        int max = -1;
        for (int i = 0; i < index; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    public static int findMaxInRight(int height[], int index) {
        int max = -1;
        for (int i = index + 1; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    // public static int trap(int[] height) {
    // int sum = 0;
    // for (int i = 0; i < height.length; i++) {
    // int maxL = findMaxInLeft(height, i);
    // int maxR = findMaxInRight(height, i);

    // int waterStoredAtIndex = Math.min(maxL, maxR) - height[i];
    // if (waterStoredAtIndex > 0)
    // sum += waterStoredAtIndex;
    // }
    // return sum;
    // }

    /*
     * find maxL and maxR as a separate array i.e., prefix sum and suffix sum
     * TC: O(3N) ~ O(N)
     * SC: O(2N)
     */
    public static int trap(int[] height) {
        int n = height.length;

        // prefix sum
        int[] prefixSum = new int[n];
        prefixSum[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
        }

        // suffix sum
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterStored = Math.min(prefixSum[i], suffixSum[i]) - height[i];
            totalWater += waterStored;
        }
        System.gc();
        return totalWater;
    }

    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("total trapped water = " + trap(height));
    }
}
