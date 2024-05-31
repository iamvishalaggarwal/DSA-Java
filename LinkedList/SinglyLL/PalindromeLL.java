package LinkedList.SinglyLL;

public class PalindromeLL {
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
     * Four steps:
     * 1) find the middle (using tortoise hare) -- O(n/2)
     * 2) reverse the second half -- O(n/2)
     * 3) compare first half and second half -- O(n/2)
     * 4) reverse again the second half (to keep the linkedlist same) -- O(n/2)
     * 
     * TC: O(2n)
     */
    public static boolean isPalindrome(Node head) {

        // for finding middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middle = slow; // till slow, it is first half
        Node newHead = reverse(middle.next); // reversing second half
        Node first = head; // head of first half
        Node last = newHead; // head of second half
        // for comparing
        while (last != null) {
            if (first.data != last.data) {
                // for reversing back (second half)
                reverse(newHead);
                return false;
            }
            first = first.next;
            last = last.next;
        }
        // for reversing back (second half)
        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 1 };
        Node head = convertToLinkedList(arr);
        System.out.println("Palindrome Linked List = " + isPalindrome(head));
    }
}
