import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatingNumbers {

    /*
     * Better Approach: Using HashMap
     * TC: O(2n)
     * SC: O(n)
     */
    // public static int[] findMissingRepeatingNumbers(int[] a) {
    // // result[0] = repeated
    // // result[1] = missing
    // int[] result = new int[2];

    // int n = a.length; // len of array

    // Map<Integer, Integer> map = new HashMap<>();

    // for (int val : a) {
    // map.put(val, map.getOrDefault(val, 0) + 1);
    // }

    // for (int i = 1; i <= n; i++) {
    // if (map.containsKey(i)) {
    // if (map.get(i) == 2) {
    // result[0] = i;
    // }
    // } else {
    // result[1] = i;
    // }
    // }
    // return result;
    // }

    /*
     * Optimal: Using maths equation
     * TC: O(n)
     * SC: O(1)
     */
    public static int[] findMissingRepeatingNumbers(int[] a) {
        long n = a.length;
        long sumOfAllNNumbers = (n * (n + 1)) / 2;
        long sumOfAllNSquares = (n * (n + 1) * (2 * n + 1)) / 6;

        long sum = 0;
        long sumOfSquares = 0;
        for (int val : a) {
            sum += val;
            sumOfSquares += (long) val * (long) val;
        }

        // X - Y
        long val1 = sum - sumOfAllNNumbers;

        // X^2 - Y^2 = X + Y
        long val2 = sumOfSquares - sumOfAllNSquares;

        val2 = val2 / val1;

        long x = (val1 + val2) / 2; // repeating number
        long y = x - val1; // missing number

        int result[] = { (int) x, (int) y };
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3 };
        int[] result = findMissingRepeatingNumbers(arr);
        System.out.println("Repeated = " + result[0]);
        System.out.println("Missing = " + result[1]);
    }
}
