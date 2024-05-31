package LinkedList.SinglyLL;

public class RemoveNthNodeFromEnd {
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

    public static int findLenOfList(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    /*
     * brute force:
     * TC: O(2n)
     * SC: O(1)
     */
    // public static Node removeNthFromEnd(Node head, int n) {
    // if (head.next == null && n == 1) {
    // return null;
    // }
    // int length = findLenOfList(head);
    // int pos = length - n + 1;
    // int count = 0;
    // Node temp = head;
    // // for removal of head
    // if (pos == 1) {
    // return head.next;
    // }
    // while (temp != null) {
    // count++;
    // if (count == pos - 1) {
    // // temp.next = temp.next != null ? temp.next.next : null;
    // Node reqNode = temp.next;
    // temp.next = temp.next.next;
    // reqNode.next = null;
    // }
    // temp = temp.next;
    // }
    // return head;
    // }

    /*
     * Optimal approach - take 2 pointers
     * TC: O(n)
     * SC: O(1)
     */
    public static Node removeNthFromEnd(Node head, int n) {
        Node fast = head, slow = head;
        // move fast to 'n' steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            // now move them one-one steps
            fast = fast.next;
            slow = slow.next;
        }
        // after completing this loop,
        // the slow should point to the prev node of reqNode
        Node reqNode = slow.next;
        slow.next = slow.next.next;
        reqNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 5, 6, 4, 7 };
        Node head = convertToLinkedList(arr);
        head = removeNthFromEnd(head, 2);
        traverse(head);
    }
}
