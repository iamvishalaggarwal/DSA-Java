
/**
 * Problem:
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
*/

import java.util.Scanner;

public class ReverseInteger {

    public static int reverse(int num) {
        long rev = 0L;
        while (num != 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }

        if (rev < Math.pow(-2, 31) || rev > (Math.pow(2, 31) - 1)) {
            return 0;
        } else
            return (int) rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();
        System.out.println("Reverse Integer = " + reverse(num));
        sc.close();
    }
}
