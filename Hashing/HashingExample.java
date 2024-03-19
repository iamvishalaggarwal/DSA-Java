package Hashing;

public class HashingExample {

    public static void main(String[] args) {
        int arr[] = new int[1000000];
        // int arr2[] = new int[10000000000]; --> problem: out of range error for 10^10

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // System.out.println(arr + " " + arr2);
    }
}
