import java.util.Scanner;

public class PalindromeNumber {

    public static long reverse(int num) {
        long rev = 0L;
        while (num != 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");

        int num = sc.nextInt();

        if (num >= 0) {
            if (num == reverse(num)) {
                System.out.println("Palindrome");
            } else
                System.out.println("Not Palidrome.");
        } else {
            System.out.println("Not Palindrome.");
        }
        sc.close();
    }
}
