package LinkedList.SinglyLL;

class Node {
    // need to store data and it's address
    int data;
    Node next;

    public Node() {
        this.data = -1;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

/*
 * Problem:
 * Given the head of a singly linked list, return the middle node of the linked
 * list. If there are two middle nodes, return the second middle node.
 */

public class MiddleOfLL {

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
     * Brute Force Approach - count the nodes, then find the middle
     * TC: O(n + n/2)
     * SC: O(1)
     */
    // public static Node middleNode(Node head) {
    // int count = 0;
    // Node temp = head;
    // // find the len of LL
    // while (temp != null) {
    // count++;
    // temp = temp.next;
    // }

    // Node tempNode = head;
    // int pos = 0;
    // // finding the middle of LL using len
    // while (tempNode != null) {
    // pos++;
    // if (pos == ((count / 2) + 1)) {
    // return tempNode;
    // }
    // tempNode = tempNode.next;
    // }
    // return null; // never reach line
    // }

    /*
     * Optimal - slow and fast pointer (Tortoise Hare Approach)
     * TC: O(n/2)
     * SC: O(1)
     * 
     * Intution - if koi do step chl rha hai, so single step chlne wala
     * hmesha mid mai hoga jb double step chlne wala last m hoga
     */
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = convertToLinkedList(arr);

        System.out.println("Middle node = " + middleNode(head).data);

    }
}
