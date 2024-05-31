package LinkedList.SinglyLL;

import java.util.HashMap;

public class FindIntersectionPointInLL {

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

    /*
     * Brute force - using hashing, remember the nodes which visited
     * TC: O(m + n)
     * SC: O(m)
     */
    // public static Node getIntersectionNode(Node headA, Node headB) {
    // HashMap<Node, Integer> map = new HashMap<>();
    // Node tempA = headA;
    // while (tempA != null) {
    // map.put(tempA, 1);
    // tempA = tempA.next;
    // }
    // Node tempB = headB;
    // while (tempB != null) {
    // if (map.containsKey(tempB)) {
    // return tempB;
    // }
    // tempB = tempB.next;
    // }
    // return null;
    // }

    public static int getLength(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    /*
     * Better approach - we need to start from same point in both LL, so we find
     * the difference of both LL == steps, and whichever is max, we move the steps
     * of that respective node
     * TC: O(n + m) + O(n)
     * SC: O(1)
     */
    // public static Node getIntersectionNode(Node headA, Node headB) {
    // int lenA = getLength(headA);
    // int lenB = getLength(headB);
    // int stepsNeedToTake = -1;
    // Node target = null;
    // Node other = null;
    // if (lenA > lenB) {
    // stepsNeedToTake = lenA - lenB;
    // target = headA;
    // other = headB;
    // } else {
    // stepsNeedToTake = lenB - lenA;
    // target = headB;
    // other = headA;
    // }

    // while (stepsNeedToTake != 0) {
    // stepsNeedToTake--;
    // target = target.next;
    // }

    // while (target != null && other != null) {
    // if (target == other) {
    // return target;
    // }
    // target = target.next;
    // other = other.next;
    // }
    // return null;
    // }

    /*
     * Optimal approach - when any node reaches null while traversing then we put
     * that node on the starting point of other node
     * Base Case: if both reaches null while traversing at the same time then we
     * return null
     * TC: O(m + n)
     * SC: O(1)
     */
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node tempA = headA;
        Node tempB = headB;

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == null && tempB == null) {
                return null;
            }

            if (tempA == null) {
                tempA = headB;
            }
            if (tempB == null) {
                tempB = headA;
            }
        }
        return tempA;
    }

    public static void main(String[] args) {
        int listA[] = { 4, 1, 8, 4, 5 };
        int listB[] = { 5, 6, 1, 8, 4, 5 };
        Node headA = convertToLinkedList(listA);
        Node headB = convertToLinkedList(listB);
        Node head = getIntersectionNode(headA, headB);
    }
}
