package SlidingWindowProblem;

/*
 * Type 3 of sliding window problem - as in which we need to find the count of subarrays
 */
public class BinarySubarraysWithSum {

    /*
     * Brute force - find all subarrays
     */
    // public static int numSubarraysWithSum(int[] nums, int goal) {
    // int numberOfSubarrays = 0;
    // for (int i = 0; i < nums.length; i++) {
    // int sum = 0;
    // for (int j = i; j < nums.length; j++) {
    // sum = sum + nums[j];
    // if (sum == goal) {
    // numberOfSubarrays++;
    // } else if (sum > goal) {
    // break;
    // }
    // }
    // }
    // return numberOfSubarrays;
    // }

    /*
     * Optimal approach - using sliding window (type 3)
     * Intuition - we cannot directly find the number of subarrays for goal, so
     * first find the number of subarrays for <= goal and then find number of
     * subarrays <= (goal - 1) then we need to find the difference of both of them,
     * which will be equal to the goal (number of subarrays with specific sum)
     * 
     */
    public static int findSubarraysWithSmallerThanEqualsToGoal(int nums[], int goal) {
        int count = 0;
        int l = 0, r = 0;
        int sum = 0;
        // case when we have to find subarrays for sum = 0
        if (goal < 0)
            return 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return findSubarraysWithSmallerThanEqualsToGoal(nums, goal)
                - findSubarraysWithSmallerThanEqualsToGoal(nums, goal - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println("Number of subarrays with goal = " + numSubarraysWithSum(arr, goal));
    }
}
