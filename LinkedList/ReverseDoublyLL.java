package LinkedList;

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DoublyNode(int data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class ReverseDoublyLL {

    public static DoublyNode convertToDLL(int arr[]) {
        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyNode temp = new DoublyNode(arr[i]);
            temp.prev = prev;
            prev.next = temp;
            prev = prev.next;
        }
        return head;
    }

    public static void printDLL(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /*
     * Better Approach - two pointers
     * TC: O(2n)
     * SC: O(1)
     */
    // public static DoublyNode reverseDLL(DoublyNode head) {
    // DoublyNode p = head;
    // DoublyNode q = head;
    // while (q.next != null) {
    // q = q.next;
    // }
    // while (p != q) {
    // int temp = p.data;
    // p.data = q.data;
    // q.data = temp;

    // p = p.next;
    // q = q.prev;

    // if (q.next == p) {
    // break;
    // }
    // }
    // return head;
    // }

    public static DoublyNode reverseDLL(DoublyNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoublyNode prevNode = null;
        DoublyNode current = head;

        while (current != null) {
            prevNode = current.prev;

            // now we swap the next and prev links
            current.prev = current.next;
            current.next = prevNode;

            // now move the current to the next node,
            // as the links are swapped so we use '.prev' for next node
            current = current.prev;
        }

        return prevNode.prev;
    }

    public static void main(String[] args) {
        int arr[] = { 75, 122, 59 };
        DoublyNode head = convertToDLL(arr);
        head = reverseDLL(head);
        printDLL(head);
    }
}
