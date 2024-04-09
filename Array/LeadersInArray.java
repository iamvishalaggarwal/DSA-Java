package Array;

import java.util.ArrayList;

public class LeadersInArray {

    /*
     * Brute Force: Checking for every elements
     * TC: O(n*n)
     * SC: O(n)
     */
    // public static ArrayList<Integer> leaders(int arr[]) {
    // ArrayList<Integer> list = new ArrayList<>();

    // for (int i = 0; i < arr.length - 1; i++) {
    // boolean isLeader = true;
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[i] < arr[j]) {
    // isLeader = false;
    // break;
    // }
    // }
    // if (isLeader) {
    // list.add(arr[i]);
    // }
    // }
    // list.add(arr[arr.length - 1]);
    // return list;
    // }

    public static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int max = arr[arr.length - 1];
        list.add(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };
        System.out.print("Leader elements : ");
        for (int val : leaders(arr)) {
            System.out.print(val + " ");
        }
    }
}
