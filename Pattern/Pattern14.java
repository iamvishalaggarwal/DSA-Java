package Pattern;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            char k = 'A';

            for (int j = 0; j <= i; j++) {
                System.out.print(k++ + " ");

            }
            System.out.println();
        }
        sc.close();
    }
}
