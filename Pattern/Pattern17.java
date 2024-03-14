package Pattern;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int space = 1; space <= num - i; space++) {
                System.out.print(" ");
            }
            char character = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(character++);
            }
            char character2 = (char) ('A' + i - 2);
            for (int j = 1; j < i; j++) {
                System.out.print(character2--);
            }
            System.out.println();
        }
        sc.close();
    }
}
