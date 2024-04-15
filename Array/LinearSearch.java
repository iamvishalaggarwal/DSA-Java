
public class LinearSearch {

    /*
     * Time Complexity: O(n).
     * Space Complexity : O(1)
     */
    public static int findIndex(int arr[], int element) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        int element = 0;
        System.out.print("Index of " + element + " = " + findIndex(arr, element));
    }
}
