package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    /*
     * Brute force -
     * TC: O(n^2)
     * SC: O(k)
     */
    // public static int[] maxSlidingWindow(int[] nums, int k) {
    // int result[] = new int[nums.length - k + 1];

    // int i = 0;
    // int j = i + k - 1;
    // while (j < nums.length) {
    // int max = Integer.MIN_VALUE;
    // for (int x = i; x <= j; x++) {
    // max = Math.max(max, nums[x]);
    // }
    // result[i] = max;
    // i++;
    // j = i + k - 1;
    // }

    // return result;
    // }

    /*
     * Optimal -
     * need to use deque (using deque as using this we can push & remove from front
     * and back both)
     * - remove the element from the front of the queue if it is out of range (of
     * current sliding window)
     * - store the element in decreasing order, push the smaller element at the
     * right and remove the greater element from the right if found
     * - store the element from left (front) into result
     * 
     * TC: O(n) + O(n)
     * SC: O(k)
     */
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0; // store index

        // using deque as using this we can push & remove from front and back both
        Deque<Integer> q = new ArrayDeque<>(); // we can also implement this using doubly linked list

        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i); // adding index to the back of the queue
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        for (int val : maxSlidingWindow(nums, k))
            System.out.print(val + " ");
    }
}
