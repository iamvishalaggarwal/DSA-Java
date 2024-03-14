package Pattern;

import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            char character = (char) ('A' + num - i);
            for (int j = 1; j <= i; j++) {
                System.out.print(character++);
            }
            System.out.println();
        }
        sc.close();
    }
}
