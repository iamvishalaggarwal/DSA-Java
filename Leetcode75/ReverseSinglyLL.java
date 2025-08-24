package Leetcode75;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseSinglyLL {
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
     * Brute force approach - Using extra space (two pass approach)
     * TC: O(2n)
     * SC: O(n)
     */
    // public static void reverse(Node head) {
    // ArrayList<Integer> list = new ArrayList<>();
    // Node temp = head;
    // while (temp != null) {
    // list.add(temp.data);
    // temp = temp.next;
    // }
    // temp = head;
    // for (int i = list.size() - 1; i >= 0; i--) {
    // temp.data = list.get(i);
    // temp = temp.next;
    // }
    // }

    /*
     * Optimal approach - reversing the links (using iterative method)
     * TC: O(n)
     * SC: O(1)
     */
    // public static Node reverse(Node head) {
    // Node temp = head;
    // Node prev = null;
    // while (temp != null) {
    // Node front = temp.next;
    // temp.next = prev;
    // prev = temp;
    // temp = front; // temp.next (we cann't use this as it is replaced with prev
    // link)
    // }
    // return prev;
    // }

    /*
     * Optimal approach - reversing the links (using recursive method)
     * TC: O(n)
     * SC: O(N) -> for recursive stack space
     */
    public static Node reverse(Node head) {
        // for empty or single node LL
        // base condition
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);
        Node front = head.next;
        head.next = null;
        front.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        Node head = convertToLinkedList(arr);
        head = reverse(head);
        traverse(head);
    }
}
