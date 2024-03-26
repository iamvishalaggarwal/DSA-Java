import java.util.Scanner;

public class Datatype {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any datatype: ");
        String input = sc.next();

        switch (input.toLowerCase()) {
            case "integer":
                System.out.println("4 bytes");
                break;
            case "float":
                System.out.println("4 bytes");
                break;
            case "double":
                System.out.println("8 bytes");
                break;
            case "long":
                System.out.println("8 bytes");
                break;
            case "character":
                System.out.println("1 byte");
                break;
            default:
                break;
        }
        sc.close();

    }
}

// Another Approach

// public class Solution {
// public static int dataTypes(String type) {

// if (type.equals("Integer"))
// return 4;
// else if (type.equals("Long"))
// return 8;
// else if (type.equals("Float"))
// return 4;
// else if (type.equals("Double"))
// return 8;
// else if (type.equals("Character"))
// return 1;
// else // 'type' should have matched with some data type above
// return -1; // Should not be returned
// }
// }