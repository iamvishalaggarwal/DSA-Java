package LinkedList.SinglyLL;

/**
 * Node
 */
class Node {
    // need to store data and it's address
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

/*
 * Linkedlist -
 * - contagious memory location
 * - real life example: browser
 * - usecase: stack, queue
 */

public class SinglyLinkedList {

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

    public static int lengthOfLinkedList(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4 };
        Node head = convertToLinkedList(arr);

        // for traversing linked list
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        System.out.println("length = " + lengthOfLinkedList(head));
    }
}
