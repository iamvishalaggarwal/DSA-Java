import java.util.Scanner;

public class PrintOneToNUsingArray {

    public static int[] printNos(int x) {
        int[] arr = new int[x];
        num(x, arr);
        return arr;
    }

    public static void num(int x, int[] arr) {
        if (x == 0) {
            return;
        } else {
            arr[x - 1] = x;
            num(x - 1, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int num = sc.nextInt();
        int arr[] = printNos(num);
        for (int val : arr) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
