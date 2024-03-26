
/**
 * Example:
Sample Input 1:
5
Sample Output 1:
0 1 1 2 3
*/

import java.util.Scanner;

public class PrintFibonacciSeries {
    // TC: O(n)+O(n) and SC: O(n)
    public static int[] generateFibonacciNumbers(int n) {
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                result[i] = i;
            } else {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int n = sc.nextInt();

        System.out.println("Fibonacci series : ");
        for (int val : generateFibonacciNumbers(n)) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
