package Pattern;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {

            for (int space = 0; space < i; space++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * (num - i - 1) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
