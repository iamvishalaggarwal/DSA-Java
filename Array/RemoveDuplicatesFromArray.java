
/**
 * Input: arr[1,1,2,2,2,3,3]
 * 
 * Output: arr[1,2,3,_,_,_,_]
 * 
 * Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore
 * return 3 after assigning [1,2,3] in the beginning of the array.
 */

public class RemoveDuplicatesFromArray {

    // Optimal Approach - TC: O(N)
    public static int removeDuplicates(int[] arr) {
        // putting all the unique elements in the starting
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                // swap arr[index + 1] and arr[i]
                int temp = arr[i];
                arr[i] = arr[index + 1];
                arr[index + 1] = temp;

                index++;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };

        int len = removeDuplicates(arr);

        System.out.print("Array after removing duplicates = ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
