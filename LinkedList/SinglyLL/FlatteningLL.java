package LinkedList.SinglyLL;

import java.util.ArrayList;

/*
Problem: Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
For more clarity have a look at the printList() function in the driver code.

Example - 
Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7    20    22    35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
 */

/**
 * Node
 */
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        this.data = d;
        this.next = null;
        this.bottom = null;
    }
}

public class FlatteningLL {
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

    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /*
     * Approach -
     * store all the elements in array, sort this array and make a vertical linked
     * list from this
     * TC: O(2*m*n) + O((m*n)log(m*n))
     * SC: O(2*m*n)
     */
    // public static Node flatten(Node head) {
    // ArrayList<Integer> list = new ArrayList<>();

    // Node temp = head;
    // while (temp != null) {
    // Node t = temp;
    // while (t != null) {
    // list.add(t.data);
    // t = t.bottom; // moving towards bottom
    // }
    // temp = temp.next;
    // }

    // list.sort(null);
    // if (list.size() == 0) {
    // return null;
    // }

    // // converting this array to LL
    // Node newhead = new Node(list.get(0));
    // temp = newhead;
    // for (int i = 1; i < list.size(); i++) {
    // Node newNode = new Node(list.get(i));
    // temp.bottom = newNode;
    // temp = temp.bottom;
    // }
    // return newhead;
    // }

    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                res.bottom = temp1;
                res = res.bottom;
                temp1 = temp1.bottom; // vertical LLs
            } else {
                res.bottom = temp2;
                res = res.bottom;
                temp2 = temp2.bottom;
            }
            res.next = null;
        }
        if (temp1 != null) {
            res.bottom = temp1;
        } else {
            res.bottom = temp2;
        }
        if (dummy.bottom != null) {
            dummy.bottom.next = null;
        }
        return dummy.bottom;
    }

    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergedHead = flatten(head.next);
        return merge(head, mergedHead);
    }

    public static void main(String[] args) {

    }
}
