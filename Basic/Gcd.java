// Gcd is the greatest number which is divided by both a and b.

import java.util.Scanner;

public class Gcd {

    // Brute Force Approach - TC: O(n)
    public static int gcd(int a, int b) {
        int minNumber = a > b ? b : a;
        int gcdValue = 1;
        while (minNumber > 0) {
            if (a % minNumber == 0 && b % minNumber == 0) {
                gcdValue = minNumber;
                break;
            }
            minNumber--;
        }
        return gcdValue;
    }

    // Optimal Approach - TC: O(logɸmin(a,b)), where ɸ is 1.61
    // According to euclidean algorithm - gcd(a, b) == gcd(a-b,b) where a>b ==
    // or gcd(a, b) == gcd(a%b,b)
    public static int gcdOptimalApproach(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers = ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("GCD = " + gcd(num1, num2));
        sc.close();
    }
}
