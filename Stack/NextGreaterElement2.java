package Stack;

import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */
public class NextGreaterElement2 {

    /*
     * Brute force -
     * TC: O(n^2)
     * SC: O(1)
     */
    // public static int[] nextGreaterElements(int[] nums) {
    // int i = 0, n = nums.length;
    // int res[] = new int[n];
    // while (i < n) {
    // int j = i + 1;
    // while (i != (j % n)) {
    // if (nums[i] < nums[j % n]) {
    // res[i] = nums[j % n];
    // break;
    // }
    // j++;
    // }
    // if (i == (j % n)) {
    // res[i] = -1;
    // }
    // i++;
    // }
    // return res;
    // }

    /*
     * TC: O(2n + 2n) ~ O(n)
     * SC: O(n)
     */
    public static int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                res[i] = !stack.empty() ? stack.peek() : -1;
            }
            stack.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 1, 2, 6, 0 };
        for (int val : nextGreaterElements(nums))
            System.out.print(val + " ");

    }
}
