import java.util.Scanner;

public class FibonacciSeries {
    // TC: O(2^N) and SC: O(N)
    public static int fiboAtN(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fiboAtN(n - 1) + fiboAtN(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int n = sc.nextInt();

        System.out.println("Fibonacci number at " + n + " index = " + fiboAtN(n));
        sc.close();
    }
}
