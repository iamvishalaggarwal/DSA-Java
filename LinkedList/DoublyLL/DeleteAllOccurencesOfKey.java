package LinkedList.DoublyLL;

public class DeleteAllOccurencesOfKey {
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
     * Approach -
     * TC: O(n)
     * SC: O(1)
     */
    public static DoublyNode deleteAllOccurOfX(DoublyNode head, int x) {
        if (head == null) {
            return null;
        }

        // if key is present on head
        while (head != null && head.data == x) {
            head = head.next;

            if (head != null) { // when key is present on all nodes of LL
                head.prev = null;
            }
        }

        DoublyNode temp = head;
        while (temp != null) {
            if (temp.data == x) {
                // if key is on tail
                if (temp.next == null) {
                    DoublyNode prev = temp.prev;
                    prev.next = null;
                    temp.prev = null;
                } else {
                    // key in middle
                    DoublyNode prev = temp.prev;
                    prev.next = temp.next;
                    temp.next.prev = prev;
                    temp.prev = null;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 2 };
        DoublyNode head = convertToDLL(arr);
        head = deleteAllOccurOfX(head, 2);
        printDLL(head);
    }
}
