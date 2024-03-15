package Pattern;

import java.util.Scanner;

public class Pattern20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            // space
            for (int space = num * 2 - 2; space > 2 * i; space--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i <= num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * i + 2; space++) {
                System.out.print(" ");
            }
            for (int j = 0; j < num - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
