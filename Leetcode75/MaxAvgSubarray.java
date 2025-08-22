package Leetcode75;

public class MaxAvgSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0;
        double avg = 0.0;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        // multiply by 1.0 to convert the int to double, as sum and k both are int, so
        // for finding exact avg we need floating point number (double), not int
        avg = sum * 1.0 / k;
        res = avg;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k]; // keep the window size as it is
            // we just need to add the next one, and remove leftmost, as we need to maintain
            // the window size

            avg = sum * 1.0 / k;
            res = Math.max(avg, res);
        }
        return res;
    }
}
