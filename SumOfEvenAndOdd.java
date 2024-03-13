
/**
 * Problem:
 * Write a program to input an integer 'n' and print the sum of all its even digits and the sum of all its odd digits separately.
 * Digits mean numbers, not places! That is, if the given integer is "132456", even digits are 2, 4, and 6, and odd digits are 1, 3, and 5.
 */

import java.util.Scanner;

public class SumOfEvenAndOdd {

    public static int[] getSum(int n) {
        int result[] = new int[2];
        int rem = 0;
        while (n != 0) {
            rem = n % 10;
            if (rem % 2 == 0) {
                result[0] += rem;
            } else {
                result[1] += rem;
            }
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[] = getSum(num);
        System.out.println(arr[0] + " " + arr[1]);
        sc.close();
    }

}
