package LinkedList.SinglyLL;

import java.util.ArrayList;

/*
 * Problem:
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
 */

public class LinkedListCycle {
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
    // public static boolean hasCycle(Node head) {
    // ArrayList<Node> listOfNodes = new ArrayList<>();
    // if (head == null) {
    // return false;
    // }

    // Node temp = head;
    // while (temp != null) {
    // if (listOfNodes.contains(temp)) {
    // return true;
    // } else {
    // listOfNodes.add(temp);
    // }
    // temp = temp.next;
    // }
    // return false;
    // }

    /*
     * Optimal Way - Tortoise and Hare Approach
     * TC: O(n)
     * SC: O(1)
     * 
     * Intution - as the slow is moving by 1 and fast by 2, so the difference
     * from fast to slow is d (= d-1, as fast = 2 and slow = 1, so, distance from
     * fast to slow = d - 2 + 1 = d - 1) which will surely reduce to 0 if there is a
     * cycle in LL
     */
    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) // cycle found
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4 };
        Node head = convertToLinkedList(arr);
        // System.out.println("List has cycle = " + hasCycle(head));
    }
}
