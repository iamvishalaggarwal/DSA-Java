package LinkedList.SinglyLL;

public class Add1ToNumberInLL {
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

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);
        Node front = head.next;
        head.next = null;
        front.next = head;
        return newHead;
    }

    /*
     * Brute Approach - reverse the LL and then add and again reverse
     * TC: O(n) + O(n) + O(n)
     * SC: O(1)
     */
    // public static Node addOne(Node head) {
    // // reverse
    // // add one till the carry exists
    // // reverse
    // if (head == null) {
    // return null;
    // }

    // head = reverse(head);
    // Node temp = head;

    // Node prev = temp;
    // int carry = 1; // take the number as carry which we need to add for
    // simplification

    // while (carry != 0) {
    // int sum = carry;
    // if (temp != null) {
    // sum += temp.data;
    // temp.data = sum % 10;
    // } else {
    // // e.g: 9 -> 9 -> 9
    // Node newNode = new Node(sum % 10);
    // prev.next = newNode;
    // temp = newNode;
    // }
    // prev = temp;
    // temp = temp.next;
    // carry = sum / 10;
    // }

    // return reverse(head);
    // }

    /*
     * Using recursion (backtracking):
     * TC: O(n)
     * SC: O(n) -- recursive stack space
     */
    public static int addCarry(Node head) {
        if (head == null) {
            return 1; // as we need to add one
        }
        int currCarry = addCarry(head.next);
        int val = head.data + currCarry;
        int carry = val / 10;
        head.data = val % 10;
        return carry;
    }

    public static Node addOne(Node head) {
        int carry = addCarry(head);
        if (carry != 0) {
            // edge case eg: 9
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 9 };
        Node head = convertToLinkedList(arr);
        head = addOne(head);
        traverse(head);
    }
}
