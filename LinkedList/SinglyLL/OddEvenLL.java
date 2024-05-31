package LinkedList.SinglyLL;

/*
 * Problem:
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
 */

public class OddEvenLL {

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
     * Optimal -
     * TC: O(n)
     * SC: O(1)
     */
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int count = 1;

        Node dummyNodeOdd = new Node(-1);
        Node dummyNodeEven = new Node(-1);
        Node tempOdd = dummyNodeOdd;
        Node tempEven = dummyNodeEven;
        // connecting odd and even index elements
        while (temp != null) {
            if (count % 2 == 0) { // add to even LL
                tempEven.next = temp;
                tempEven = tempEven.next;
            } else { // add to odd LL
                tempOdd.next = temp;
                tempOdd = tempOdd.next;
            }
            temp = temp.next;
            count++;
        }
        if (tempEven.next != null)
            tempEven.next = null;
        if (tempOdd.next != null)
            tempOdd.next = null;
        // now, connect odd elements LL to even LL
        tempOdd.next = dummyNodeEven.next;
        return dummyNodeOdd.next;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 5, 6, 4, 7 };
        Node head = convertToLinkedList(arr);
        head = oddEvenList(head);
        traverse(head);
    }
}
