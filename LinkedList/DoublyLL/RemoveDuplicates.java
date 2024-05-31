package LinkedList.DoublyLL;

public class RemoveDuplicates {
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
     * Checking the next node, as the LL is sorted
     * TC: O(n)
     * SC: O(1)
     */
    public static DoublyNode removeDuplicates(DoublyNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoublyNode temp = head;
        while (temp.next != null) {
            DoublyNode nextNode = temp.next;
            DoublyNode prevNode = temp.prev;
            if (temp.data == nextNode.data) {
                if (prevNode != null) {
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 6, 13, 13, 13, 14, 15, 15, };
        DoublyNode head = convertToDLL(arr);
        head = removeDuplicates(head);
        printDLL(head);
    }
}
