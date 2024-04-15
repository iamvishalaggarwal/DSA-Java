
import java.util.ArrayList;

public class UnionOfTwoSortedArray {

    /*
     * OPTIMAL SOLUTION
     * TC: O(m + n)
     * SC: O(m + n) --> only for returning result
     */
    public static ArrayList<Integer> unionOfArrays(int arr1[], int arr2[]) {
        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                // checking that the element which we are adding,
                // is already exists in array or not ? (by checking last element)
                // if not exists --> add & increment pointer [in array 1]
                // else skip it and increment pointer only
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i])
                    union.add(arr1[i]);
                i++;
            } else {
                // checking that the element which we are adding,
                // is already exists in array or not ? (by checking last element)
                // if not exists --> add & increment pointer [in array 2]
                // else skip it and increment pointer only
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j])
                    union.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) { // IF any element left in arr1
            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i])
                union.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) { // IF any element left in arr2
            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j])
                union.add(arr2[j]);
            j++;
        }
        return union;
    }

    /*
     ** Brute Force Approach
     ** TC: O(nlogn) + O(mlogn) + O(m + n)
     ** SC: O(m+n) + O(m + n) --> one for set and other for returning result
     * public static ArrayList<Integer> unionOfArrays(int arr1[], int arr2[]) {
     * SortedSet<Integer> set = new TreeSet<>();
     * for (int i = 0; i < arr1.length; i++) {
     * set.add(arr1[i]);
     * }
     * for (int i = 0; i < arr2.length; i++) {
     * set.add(arr2[i]);
     * }
     * ArrayList<Integer> union = new ArrayList<>();
     * for (int val : set) {
     * union.add(val);
     * }
     * return union;
     * }
     */

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 19 };
        int arr2[] = { 2, 3, 4, 4, 5, 17 };

        System.out.println("Union = ");
        for (int val : unionOfArrays(arr1, arr2)) {
            System.out.print(val + " ");
        }

    }
}
