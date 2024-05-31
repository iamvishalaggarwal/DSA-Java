package LinkedList.SinglyLL;

// import java.util.ArrayList;

/*
Problem:
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */

public class FindStartingPointInCycle {
    public static Node convertToLinkedList(int[] arr) {
        // for converting array to linked list
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    /*
     * Brute force - using extra space
     * TC: O(n)
     * SC: O(n)
     */
    // public Node detectCycle(Node head) {
    // ArrayList<Node> listOfNodes = new ArrayList<>();
    // Node temp = head;
    // while (temp != null) {
    // if (listOfNodes.contains(temp)) {
    // return temp;
    // } else {
    // listOfNodes.add(temp);
    // }
    // temp = temp.next;
    // }
    // return null;
    // }

    public static Node detectCycle(Node head) {

        // Step 1: detection of loop
        Node slow = head, fast = head;

        // condition for linear (odd & even length) LL
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) // when they collide
            {
                // step 2: we need to move slow back to head, and then move both one by one
                // when they both collide, this will be the starting point
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // or either fast, as it they are colliding
            }
        }
        return null;
    }

    public static int findLengthOfCycle(Node head) {
        Node startingOfLoop = detectCycle(head);
        if (startingOfLoop == null) {
            return 0;
        }

        Node temp = startingOfLoop.next;
        int len = 1;
        while (temp != startingOfLoop) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4 };
        Node head = convertToLinkedList(arr);
        // System.out.println("List has cycle = " + hasCycle(head));
    }
}
