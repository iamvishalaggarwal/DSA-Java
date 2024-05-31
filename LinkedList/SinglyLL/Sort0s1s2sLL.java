package LinkedList.SinglyLL;

public class Sort0s1s2sLL {
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
     * Brute force - count all the occurences
     * TC: O(2n)
     * SC: O(1)
     */
    // public static Node segregate(Node head) {
    // if (head == null || head.next == null) {
    // return head;
    // }
    // Node temp = head;
    // int count0 = 0;
    // int count1 = 0;
    // int count2 = 0;
    // while (temp != null) {
    // if (temp.data == 0)
    // count0++;
    // else if (temp.data == 1)
    // count1++;
    // else
    // count2++;
    // temp = temp.next;
    // }
    // temp = head;
    // while (count0 != 0) {
    // temp.data = 0;
    // temp = temp.next;
    // count0--;
    // }
    // while (count1 != 0) {
    // temp.data = 1;
    // temp = temp.next;
    // count1--;
    // }
    // while (count2 != 0) {
    // temp.data = 2;
    // temp = temp.next;
    // count2--;
    // }
    // return head;
    // }

    /*
     * Optimal - segregate all three types of LL and then link
     * TC: O(n)
     * SC: O(1)
     */
    public static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);

        Node temp0 = dummy0, temp1 = dummy1, temp2 = dummy2;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                temp0.next = temp;
                temp0 = temp0.next;
            } else if (temp.data == 1) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        Node resultDummy = new Node(-1);
        Node resultTemp = resultDummy;
        if (dummy0.next != null) {
            resultTemp.next = dummy0.next;
            resultTemp = temp0;
        }
        if (dummy1.next != null) {
            resultTemp.next = dummy1.next;
            resultTemp = temp1;
        }
        if (dummy2.next != null) {
            resultTemp.next = dummy2.next;
        }
        temp2.next = null;

        return resultDummy.next;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 2 };
        Node head = convertToLinkedList(arr);
        head = segregate(head);
        traverse(head);
    }
}
