public class MaximumProductSubarray {

    /*
     * Brute Force - checking all subarray's product
     * 
     * TC: O(n^2)
     * SC: O(1)
     */
    // public int maxProduct(int[] nums) {
    // int product, max = Integer.MIN_VALUE;
    // for (int i = 0; i < nums.length; i++) {
    // product = 1;
    // for (int j = i; j < nums.length; j++) {
    // product *= nums[j];
    // if (product > max) {
    // max = product;
    // }
    // }
    // }
    // return max;
    // }

    /*
     * Optimal Approach - Using prefix suffix technique
     * 
     * TC: O(n)
     * SC: O(1)
     */
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, -2, 4 };

        System.out.println("Max product of subarray = " + maxProduct(arr));
    }

}