package LinkedList.SinglyLL;

import java.util.ArrayList;

public class SortLL {
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
     * Brute Force - by keeping all the elements in array and then sort and back to
     * LL
     * TC: O(n) + O(nlogn) + O(n)
     * SC: O(n)
     */
    // public static Node sort(Node head) {
    // ArrayList<Integer> list = new ArrayList<>();
    // Node temp = head;
    // while (temp != null) {
    // list.add(temp.data);
    // temp = temp.next;
    // }
    // list.sort(null);
    // temp = head;
    // int i = 0;
    // while (temp != null) {
    // temp.data = list.get(i);
    // i++;
    // temp = temp.next;
    // }
    // return head;
    // }

    public static Node findMiddle(Node head) {
        // Note: we need to put fast, on the next of slow
        // as we need to find the first middle [in case of even length] (not the second
        // middle, which we usually
        // find using tortoise hare approach)
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
     * Using merge sort -
     * steps:
     * 1) find middle
     * 2) divide the LL into two parts
     * 3) merge sorted LL
     */
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null; // for making both LL seperate
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return merge(leftHead, rightHead);
    }

    public static Node merge(Node left, Node right) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 3 };
        Node head = convertToLinkedList(arr);
        head = mergeSort(head);
        traverse(head);
    }
}
