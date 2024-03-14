package Pattern;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number = ");
        int num = sc.nextInt();

        int k = 1;
        for (int i = 0; i < num; i++) {
            k = i % 2 == 0 ? 1 : 0; // as only even rows started with 1
            for (int j = 0; j <= i; j++) {
                System.out.print(k);
                k = k == 0 ? 1 : 0; // for toggle
            }
            System.out.println();
        }
        sc.close();
    }
}
