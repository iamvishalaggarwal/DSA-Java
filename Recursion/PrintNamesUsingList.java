import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintNamesUsingList {

    public static List<String> printNtimes(int n) {
        List<String> strList = new ArrayList<>();
        printFunc(n, strList, "Coding Ninjas");
        return strList;
    }

    public static void printFunc(int n, List<String> arr, String value) {
        if (n == 0) {
            return;
        } else {
            arr.add(value);
            printFunc(n - 1, arr, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int num = sc.nextInt();
        List<String> strList = printNtimes(num);
        strList.forEach(val -> System.out.print(val + " "));
        sc.close();
    }
}
