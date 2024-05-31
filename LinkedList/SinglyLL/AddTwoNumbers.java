package LinkedList.SinglyLL;

public class AddTwoNumbers {
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

    public static Node add(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        if (head.next == null) {
            head.next = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    /*
     * Better Approach -
     * TC: O(max(m, n)) + adding note time
     * SC: O(max(m, n))
     */
    // public static Node addTwoNumbers(Node l1, Node l2) {
    // Node output = null;
    // Node temp1 = l1;
    // Node temp2 = l2;
    // int prevCarry = 0;
    // while (temp1 != null && temp2 != null) {
    // int data = temp1.data + temp2.data + prevCarry;
    // int currentCarry = 0;
    // if (data >= 10) {
    // currentCarry = data / 10;
    // data = data % 10;
    // }
    // output = add(output, data);

    // temp1 = temp1.next;
    // temp2 = temp2.next;
    // // storing carry
    // prevCarry = currentCarry;
    // }

    // while (temp1 != null) {
    // int data = temp1.data + prevCarry;
    // int currentCarry = 0;
    // if (data >= 10) {
    // currentCarry = data / 10;
    // data = data % 10;
    // }
    // output = add(output, data);
    // temp1 = temp1.next;
    // prevCarry = currentCarry;
    // }
    // while (temp2 != null) {
    // int data = temp2.data + prevCarry;
    // int currentCarry = 0;
    // if (data >= 10) {
    // currentCarry = data / 10;
    // data = data % 10;
    // }
    // output = add(output, data);
    // temp2 = temp2.next;
    // prevCarry = currentCarry;
    // }

    // if (prevCarry != 0) {
    // output = add(output, prevCarry);
    // }

    // return output;
    // }

    /*
     * Optimised - Using trick of dummyNode
     * 
     * TC: O(max(m,n))
     */
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        while ((l1 != null || l2 != null) || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 4 };
        int arr2[] = { 0, 6, 8, 6, 7 };
        Node l1 = convertToLinkedList(arr1);
        Node l2 = convertToLinkedList(arr2);

        Node outputHead = addTwoNumbers(l1, l2);
        System.out.print("output = ");
        traverse(outputHead);

    }
}
