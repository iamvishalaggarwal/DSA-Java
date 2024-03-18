import java.util.Scanner;

public class PalindromeString {
    // using parameterised recursion
    // Note: not working for alphanumeric characters
    public static boolean isPalindromeString(String str, int start) {
        if (start >= str.length() / 2) {
            return true;
        }
        int len = str.length();
        if (str.charAt(start) != str.charAt(len - 1 - start)) {
            return false;
        }
        return isPalindromeString(str, start + 1);
    }

    // for alphanumeric character as well
    // eg: A man, a plan, a canal: Panama --> palindrome
    static private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);
            if (!Character.isLetterOrDigit(l))
                left++;
            else if (!Character.isLetterOrDigit(r))
                right--;
            else if (Character.toLowerCase(l) != Character.toLowerCase(r))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any string : ");
        String str = sc.nextLine();
        // if (isPalindromeString(str.toLowerCase(), 0)) {
        // System.out.println(str + " is Palindrome.");
        // } else {
        // System.out.println(str + " is not Palindrome.");
        // }

        if (isPalindrome(str.toLowerCase())) {
            System.out.println(str + " is Palindrome.");
        } else {
            System.out.println(str + " is not Palindrome.");
        }
        sc.close();
    }
}
