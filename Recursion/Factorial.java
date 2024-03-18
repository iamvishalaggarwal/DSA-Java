// Note: valid for only n <= 20

import java.util.Scanner;

class Factorial {

    public static long factUsingRecursion(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factUsingRecursion(n - 1);
    }

    public static long factUsingLoop(long n) {
        long fact = 1;

        if (n == 0 || n == 1) {
            return fact;
        }
        for (long i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        long num = sc.nextLong();

        System.out.println("Factorial = " + factUsingRecursion(num));

        sc.close();
    }
}