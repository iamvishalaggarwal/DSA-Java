import java.util.Scanner;

public class SwitchCaseStatement {

    public static double areaSwitchCase(int ch, double[] a) {
        double result = 0.0;
        switch (ch) {
            case 1:
                result = Math.PI * Math.pow(a[0], 2);
                break;
            case 2:
                result = a[0] * a[1];
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        double a[] = new double[2];
        switch (ch) {
            case 1:
                a[0] = sc.nextInt();
                break;

            case 2:
                a[0] = sc.nextInt();
                a[1] = sc.nextInt();
                break;
        }

        System.out.println(areaSwitchCase(ch, a));
        sc.close();
    }
}
