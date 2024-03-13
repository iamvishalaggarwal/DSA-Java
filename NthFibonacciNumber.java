import java.util.Scanner;

public class NthFibonacciNumber {

    public static int findNthFibonacciNumber(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return findNthFibonacciNumber(num - 1) + findNthFibonacciNumber(num - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println(findNthFibonacciNumber(num));
        sc.close();
    }
}
