package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountFrequencyOfElement {
    // Time Complexity: O(N)
    // Space Complexity: O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length = ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> mapArray = new HashMap<Integer, Integer>();

        for (int val : arr) {
            if (mapArray.get(val) == null) {
                mapArray.put(val, 1);
            } else {
                mapArray.put(val, mapArray.get(val) + 1);
            }
        }
        for (int val : mapArray.keySet()) {
            System.out.println(val + " -> " + mapArray.get(val));
        }
        sc.close();
    }
}
