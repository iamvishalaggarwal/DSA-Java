import java.util.Scanner;

public class isPrimeNumber {
    public static boolean checkPrimeNumber(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int num = sc.nextInt();
        if (checkPrimeNumber(num)) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a prime number");
        }
        sc.close();
    }
}
