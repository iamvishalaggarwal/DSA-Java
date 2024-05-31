package LinkedList.DoublyLL;

import java.util.ArrayList;

public class FindPairsWithGivenSum {
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
     * check almost each pair
     * TC: O(n^2)
     * SC: O(1)
     */
    // public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(DoublyNode
    // head, int target) {
    // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    // if (head == null || head.next == null) {
    // return null;
    // }

    // DoublyNode temp = head;
    // while (temp.next != null) {
    // DoublyNode currentNode = temp.next;
    // while (currentNode != null && currentNode.data <= target) {
    // ArrayList<Integer> pair = new ArrayList<>();
    // int val = temp.data + currentNode.data;
    // if (val == target) {
    // pair.add(temp.data);
    // pair.add(currentNode.data);
    // list.add(pair);
    // } else if (val > target) {
    // break;
    // }
    // currentNode = currentNode.next;
    // }
    // temp = temp.next;
    // }

    // return list;
    // }

    /*
     * optimal approach - binary search concept (as the LL is sorted)
     * TC: O(n) + O(n)
     * SC: O(1)
     */
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(DoublyNode head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        DoublyNode tail = head;
        // find tail
        while (tail.next != null) {
            tail = tail.next;
        }

        DoublyNode left = head;
        DoublyNode right = tail;
        while (left.data < right.data) {
            ArrayList<Integer> pair = new ArrayList<>();
            if (left.data + right.data == target) {
                pair.add(left.data);
                pair.add(right.data);
                list.add(pair);

                // move both
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data > target) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 9 };
        DoublyNode head = convertToDLL(arr);
        System.out.println(findPairsWithGivenSum(head, 5));
    }
}
