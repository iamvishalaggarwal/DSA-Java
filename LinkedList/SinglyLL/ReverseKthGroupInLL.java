package LinkedList.SinglyLL;

public class ReverseKthGroupInLL {
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

    public static Node findKthNode(Node head, int k) {
        k = k - 1;
        Node temp = head;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
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

    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            Node kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp; // or nextNode
                    break;
                }
            }

            Node nextNode = kthNode.next;
            kthNode.next = null; // for making this group as seperate LL
            reverse(temp);
            if (temp == head) { // for only 1st kth group
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            // Update the pointer to the
            // last node of the previous group
            prevNode = temp;
            temp = nextNode; // moving temp to next group
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        Node head = convertToLinkedList(arr);
        head = reverseKGroup(head, k);
        traverse(head);
    }
}
