package LinkedList.SinglyLL;

public class DeleteTheMiddleNode {
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
     * Brute force -
     * TC: O(n/2) + O(n/2) ~ O(n)
     * SC: O(1)
     */
    // public static Node deleteMiddle(Node head) {
    // // for single node, there is no middle node as per problem, so we cannot
    // delete
    // // anything
    // if (head == null || head.next == null) {
    // return null ;
    // }

    // // find the middle node
    // Node slow = head, fast = head;
    // while (fast != null && fast.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // }

    // // find the prev node of middle
    // Node middle = slow;
    // Node prev = head;
    // while (prev.next != middle) {
    // prev = prev.next;
    // }

    // prev.next = prev.next.next;
    // middle.next = null;

    // return head;
    // }

    /*
     * Single pass approach -
     * TC: O(n/2)
     * SC: O(1)
     */
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        // find the prev node of middle
        // for this we can skip one step of slow, so it would be on previous node of
        // middle when fast at end
        Node slow = head, fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middle = slow.next;
        slow.next = slow.next.next;
        middle.next = null;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 7, 1, 2, 6 };
        Node head = convertToLinkedList(arr);
        head = deleteMiddle(head);
        traverse(head);
    }
}
