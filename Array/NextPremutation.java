
/* Problem:
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 */
public class NextPremutation {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int arr[], int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    /*
     * Optimal Solution:
     * TC: O(3*n)
     * SC: O(1)
     */
    public static void nextPermutation(int arr[]) {
        int n = arr.length;
        int index = -1;

        // Step 1: find the breaking point (where the dip starts)
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // edge case: when the given array (is the largest permutation, so we just
        // fallback to starting i.e, reverse the array)
        // eg: [3, 2, 1] --> [1, 2, 3]
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: find the greatest, just greatest number to the dip number and swap
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, index, i);
                break;
            }
        }

        // step 3: reverse the left over elements
        reverse(arr, index + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        nextPermutation(arr);
        System.out.print("The next permutation is: [");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }
}
