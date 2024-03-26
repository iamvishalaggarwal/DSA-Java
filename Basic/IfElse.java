import java.util.Scanner;

public class IfElse {

    public static String compareIfElse(int a, int b) {
        if (a == b) {
            return "equal";
        } else if (a > b) {
            return "greater";
        } else {
            return "smaller";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(compareIfElse(num1, num2));
        sc.close();
    }
}
