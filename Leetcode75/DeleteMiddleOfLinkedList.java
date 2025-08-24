package Leetcode75;

/**
 * Definition for singly-linked list.
 * 
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteMiddleOfLinkedList {

    public int countNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // TC: O(n) + O(n/2) ~ O(n)
    public ListNode deleteMiddle(ListNode head) {
        int count = countNodes(head);
        if (count <= 1)
            return null;

        int midIndex = (int) Math.floor(count / 2);
        ListNode temp = head;
        int curr = 0;
        while (temp != null && curr != midIndex - 1) {
            temp = temp.next;
            curr++;
        }
        temp.next = temp.next.next;
        return head;
    }

    /*
     * Single pass approach -
     * TC: O(n/2)
     * SC: O(1)
     */
    public static ListNode deleteMiddle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // find the prev node of middle
        // for this we can skip one step of slow, so it would be on previous node of
        // middle when fast at end
        ListNode slow = head, fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = slow.next.next;
        middle.next = null;
        return head;
    }
}
