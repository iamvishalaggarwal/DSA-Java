import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfDivisors {

    public static List<Integer> getListOfDivisors(int num) {
        List<Integer> divisorsList = new ArrayList<>();
        divisorsList.add(1);
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                divisorsList.add(i);
            }
        }
        divisorsList.add(num);
        return divisorsList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numbers = ");
        int num = sc.nextInt();
        List<Integer> divisorsList = getListOfDivisors(num);
        divisorsList.forEach(val -> System.out.print(val + " "));
        sc.close();
    }
}
