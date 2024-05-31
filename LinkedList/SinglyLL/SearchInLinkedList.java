package LinkedList.SinglyLL;

class Node {
    // need to store data and it's address
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class SearchInLinkedList {

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

    public static boolean isPresent(Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 3, 5 };
        int target = 10;
        Node head = convertToLinkedList(arr);
        System.out.println("target present = " + isPresent(head, target));
    }
}
