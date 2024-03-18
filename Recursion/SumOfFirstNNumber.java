import java.util.Scanner;

public class SumOfFirstNNumber {

    // functional recursion
    public static long getSumOfFirstNNumber(long num) {
        if (num <= 0) {
            return 0;
        }
        return num + getSumOfFirstNNumber(num - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a numbers = ");
        long num = sc.nextLong();

        long sum = getSumOfFirstNNumber(num);
        System.out.println("Total = " + sum);
        sc.close();
    }

}
