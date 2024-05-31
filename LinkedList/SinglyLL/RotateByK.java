package LinkedList.SinglyLL;

public class RotateByK {
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

    public static int findLen(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static Node findTail(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    /*
     * Approach -
     * TC: O(2n)
     * SC: O(1)
     */
    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = findLen(head);

        int targetIndex = len - (k % len);

        // when k == len, no need to change
        if (targetIndex == len) {
            return head;
        }

        Node temp = head;
        int count = 1;
        while (temp != null && count != targetIndex) {
            temp = temp.next;
            count++;
        }

        Node tail = findTail(head);
        Node nextNode = temp.next;
        temp.next = null;
        tail.next = head;
        head = nextNode;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = convertToLinkedList(arr);
        head = rotateRight(head, 2);
        traverse(head);
    }
}
