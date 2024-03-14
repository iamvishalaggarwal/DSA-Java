package Pattern;

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 1; i < num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * i - 2; space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= num - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // for (int i = 1; i < num; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // for (int space = 2 * (num - i + 1) - 2; space >= i; space--) {
        // System.out.print(" ");
        // }
        // // for (int j = 1; j <= i; j++) {
        // // System.out.print("*");
        // // }
        // System.out.println();
        // }
        sc.close();
    }
}
