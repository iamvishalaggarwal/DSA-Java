package Stack;

import java.util.Stack;

/*
Problem - Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Example - 
Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.
*/

public class NextGreaterElementToRight {
    /*
     * TC: O(n)
     * SC: O(n)
     */
    public static int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
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
        int nums[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
        for (int val : nextGreaterElements(nums))
            System.out.print(val + " ");

    }
}
