package Leetcode75;

// class Solution {
//      TC: O(n*n)
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) {
//             int prod = 1;
//             for (int j = 0; j < n; j++) {
//                 if (i != j) {
//                     prod *= nums[j];
//                 }
//             }
//             res[i] = prod;
//         }
//         return res;
//     }
// }

class Solution {
    // TC: O(3n)
    // SC: O(3n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // prefix array - contains product of all elements occuring before current
        // element
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // suffix array - contains product of all elements occuring after current
        // element
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // result
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}