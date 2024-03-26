import java.util.Scanner;

/**
 * UserInputOutput
 */
public class UserInputOutput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        if (input.length() == 1) {
            if (input.hashCode() <= 90 && input.hashCode() >= 65) {
                System.out.println(1);
            } else if (input.hashCode() <= 122 && input.hashCode() >= 97) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}

/**
 * Another Approach
 */

/**
 * import java.util.Scanner;
 * 
 * public class Solution {
 * 
 * public static void main(String[] args) {
 * Scanner s = new Scanner(System.in);
 * 
 * char ch = s.next().charAt(0);
 * 
 * if(ch >= 'A' && ch <= 'Z') {
 * System.out.println(1);
 * }
 * else if(ch >= 'a' && ch <= 'z') {
 * System.out.println(0);
 * }
 * else {
 * System.out.println(-1);
 * }
 * }
 * }
 */