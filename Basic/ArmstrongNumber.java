import java.util.Scanner;

public class ArmstrongNumber {

    public static boolean isArmstrongNumber(int num) {
        int length = Integer.toString(num).length();
        int sum = 0;
        int originalNum = num;
        while (num != 0) {
            sum = sum + (int) Math.pow(num % 10, length);
            num /= 10;
        }
        return originalNum == sum ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a numbers = ");
        int num = sc.nextInt();
        if (isArmstrongNumber(num)) {
            System.out.println(num + " is an Armstrong Number.");
        } else {
            System.out.println(num + " is not an Armstrong Number.");

        }
        sc.close();
    }
}
