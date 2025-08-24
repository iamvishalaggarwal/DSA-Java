package Leetcode75;

import java.util.ArrayList;

public class MaximumTwinSum {
    // TC: O(N) + O(N/2)
    // SC: O(N)
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int max = Integer.MIN_VALUE;
        int n = list.size();
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int sum = list.get(i) + list.get(n - i - 1);
            max = Math.max(sum, max);
        }
        return max;
    }

    // approach - reverse the half linkedlist, and then we can have two pointers one
    // is pointing to first LL, and second is pointing to second LL (half revsersed
    // one)
    public int pairSumOptimal(ListNode head) {
        ListNode slow = head, fast = head, first = head;
        int maxSum = 0;
        // find middle using turtle hair approach
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half, using middle (ie, slow)
        ListNode nextNode = slow, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // max sum
        while (prev != null) {
            maxSum = Math.max(maxSum, prev.val + first.val);
            prev = prev.next;
            first = first.next;
        }
        return maxSum;
    }
}
