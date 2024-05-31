package LinkedList.DoublyLL;

/**
 * Node
 */
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

public class DoublyLL {

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

    public static DoublyNode deleteHead(DoublyNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DoublyNode temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }

    public static DoublyNode deleteTail(DoublyNode head) {
        // cases:
        // empty list, or
        // only 1 element in list
        if (head == null || head.next == null) {
            return null;
        }
        DoublyNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;
        return head;
    }

    public static DoublyNode deleteAtK(DoublyNode head, int k) {
        /*
         * Following are the cases:
         * i) when prev and next both exists (somewhere middle in LL)
         * ii) when only next exists (when deleting head)
         * iii) when prev and next both not exists (single element case)
         * iv) when only have prev, not next (i.e., when k == n, lenght of LL)
         * iv) when list is empty
         */

        if (head == null || // case v
                (head.next == null && k == 1) // case iii
        ) {
            return null;
        }
        if (k == 1) {
            // delete from head (case ii)
            DoublyNode tempNode = head;
            head = head.next;
            head.prev = null;
            tempNode.next = null;
            return head;
        }

        DoublyNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            if (count == k) {
                if (tempNode.next == null) {
                    // delete from tail (case iv)
                    tempNode.prev.next = null;
                    tempNode.prev = null;
                    return head;
                } else {
                    // case i)
                    DoublyNode prevNode = tempNode.prev;
                    prevNode.next = tempNode.next;
                    tempNode.next.prev = prevNode;
                    tempNode.next = null;
                    tempNode.prev = null;
                    return head;
                }
            }
            tempNode = tempNode.next;
        }
        return head;
    }

    public static DoublyNode insertBeforeHead(DoublyNode head, int val) {
        DoublyNode newNode = new DoublyNode(val);
        head.prev = newNode;
        newNode.next = head;
        return newNode;
    }

    public static DoublyNode insertBeforeTail(DoublyNode head, int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            return newNode;
        }

        // when only have 1 element, then there will be no prev i.e., equals to
        // insertBeforeHead
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }

        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        DoublyNode prevNode = temp.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = temp;
        temp.prev = newNode;

        return head;
    }

    public static DoublyNode insertAfterTail(DoublyNode head, int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            return newNode;
        }
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static DoublyNode insertAfterK(DoublyNode head, int val, int pos) {
        DoublyNode newNode = new DoublyNode(val);

        // Note: question stated, that LL has atleast one element
        // if (head == null && pos == 1) {
        // return newNode;
        // }

        DoublyNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == pos) {
                DoublyNode nextNode = temp.next;
                if (nextNode == null) {
                    temp.next = newNode;
                    newNode.prev = temp;
                } else {
                    temp.next = newNode;
                    newNode.prev = temp;
                    newNode.next = nextNode;
                    nextNode.prev = newNode;
                }
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20 };
        DoublyNode head = convertToDLL(arr);

        // head = deleteHead(head);

        // head = deleteTail(head);

        // head = deleteAtK(head, 3);

        // head = insertBeforeHead(head, 12); // before the head

        // head = insertAfterTail(head, 12);

        head = insertBeforeTail(head, 100);

        // head = insertAfterK(head, 44, 1);
        printDLL(head);
    }
}
