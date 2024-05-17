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

public class InsertOperations {
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

    public static Node insertAtHead(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;
    }

    public static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node insertAtK(Node head, int pos, int val) {
        if (head == null) {
            if (pos == 1) {
                return new Node(val);
            } else {
                return null; // if LL is empty then we can only insert at first
            }
        }
        // insertion at head
        if (pos == 1) {
            return new Node(val, head);
        }

        Node temp = head;
        int count = 0;
        Node newNode = new Node(val);
        while (temp != null) {
            count++;
            if (count == pos - 1) { // checking for one behind k
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertBeforeValue(Node head, int val, int ele) {
        // insert ele before the value 'val'
        if (head == null) {
            return null;
        }
        if (head.data == val) {
            return new Node(ele, head);
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                Node newNode = new Node(ele);
                newNode.next = temp;
                prev.next = newNode;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = convertToLinkedList(arr);
        // head = insertAtTail(head, 10);
        // traverse(head);

        // head = insertAtK(head, 6, 100);
        // traverse(head);

        head = insertBeforeValue(head, 4, 100);
        traverse(head);
    }
}
