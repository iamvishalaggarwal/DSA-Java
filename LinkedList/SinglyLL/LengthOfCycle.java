package LinkedList.SinglyLL;

public class LengthOfCycle {
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

    // public static int findLengthOfCycle(Node head) {
    // Node startingOfLoop = detectCycle(head);
    // if (startingOfLoop == null) {
    // return 0;
    // }

    // Node temp = startingOfLoop.next;
    // int len = 1;
    // while (temp != startingOfLoop) {
    // len++;
    // temp = temp.next;
    // }
    // return len;
    // }

    /*
     * Using tortoise hare approach for detecting cycle
     * TC: O(n)
     * SC: O(1)
     */
    public static int lengthOfCycle(Node head) {

        // Step 1: detection of loop
        Node slow = head, fast = head;

        // condition for linear (odd & even length) LL
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) // when they collide
            {
                // calculate length by moving fast and reach again at slow
                fast = fast.next;
                int len = 1;
                while (slow != fast) {
                    len++;
                    fast = fast.next;
                }
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4 };
        Node head = convertToLinkedList(arr);
        // System.out.println("Length of Cycle = " + lengthOfCycle(head));
    }
}
