// Problem: A digit evenly divides ‘n’ if it leaves no remainder when dividing ‘n’.

import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        int rem = 0;
        int originalNumber = num;
        int countOfDigit = 0;
        while (num != 0) {
            rem = num % 10;
            if (rem != 0 && originalNumber % rem == 0) {
                countOfDigit++;
            }
            num /= 10;
        }

        System.out.println("Number of digits = " + countOfDigit);
        sc.close();
    }
}
