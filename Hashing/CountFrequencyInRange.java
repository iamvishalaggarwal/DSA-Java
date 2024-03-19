package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Example 1:
 * 6 4
 * 1 3 4 3 4 1
 * 2 0 2 2 0 0
 * 
 * Explanation:
 * Frequency table:
 * Number Count
 * 1 2
 * 2 0
 * 3 2
 * 4 2
 * 5 0
 * 6 0
 * 
 * Example 2:
 * Input: ‘n’ = 6 ‘x’ = 9 ‘arr’ = [1, 3, 1, 9, 2, 7]
 * Output: [2, 1, 1, 0, 0, 0]
 * Explanation: Below Table shows the number and their counts, respectively, in
 * the array
 * Number Count
 * 1 2
 * 2 1
 * 3 1
 * 4 0
 * 5 0
 * 6 0
 * 
 */

public class CountFrequencyInRange {

    public static int[] countFrequency(int n, int x, int[] nums) {
        Map<Integer, Integer> mapArray = new HashMap<Integer, Integer>();
        for (int val : nums) {
            if (mapArray.get(val) == null) {
                mapArray.put(val, 1);
            } else {
                mapArray.put(val, mapArray.get(val) + 1);
            }
        }
        int reqArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (mapArray.get(i + 1) == null) {
                reqArr[i] = 0;
            } else {
                reqArr[i] = mapArray.get(i + 1);
            }
        }
        return reqArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n means length
        int x = sc.nextInt(); // x means max-number
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int val : countFrequency(n, x, arr)) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}