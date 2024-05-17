package LinkedList;

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

public class DeleteOperationsLL {

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

    // Delete Head of LL
    public static Node deleteHead(Node head) {
        if (head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    // Delete Tail of LL
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        // second last element
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteAtK(Node head, int k) {
        // if there is empty LL
        if (head == null) {
            return head;
        }

        // if we need to delete first element, i.e, head of LL
        if (k == 1) {
            head = head.next;
            return head;
        }

        Node prev = null;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteByValue(Node head, int value) {
        if (head == null)
            return null;

        if (head.data == value) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == value) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 3, 5, 12 };
        Node head = convertToLinkedList(arr);

        // head = deleteHead(head);
        // System.out.println("Linked list = ");
        // traverse(head);

        // head = deleteTail(head);
        // traverse(head);

        // head = deleteAtK(head, 2);
        // traverse(head);

        head = deleteByValue(head, 2);
        traverse(head);

    }
}
