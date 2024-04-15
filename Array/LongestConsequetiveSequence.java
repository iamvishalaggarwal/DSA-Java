
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsequetiveSequence {

    public static boolean linearSearch(int arr[], int element) {
        for (int val : arr) {
            if (val == element) {
                return true;
            }
        }
        return false;
    }

    /*
     * Brute Force - Linear search every element and find consecutive elements count
     * TC: O(n^2)
     * SC: O(1)
     */
    public static int longestConsecutive_0(int[] arr) {
        int longest = 0; // since, if array length is zero then, no longest sequence

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int count = 1;
            while (linearSearch(arr, element + 1) == true) {
                element++;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    /*
     * Better Approach - Maitaining record for previous element and then check if
     * next
     * exists or not
     * TC: O(N * logN)
     * SC: O(1)
     */
    public static int longestConsecutive_1(int[] arr) {
        Arrays.sort(arr);
        int lastElement = Integer.MIN_VALUE;
        int count = 0;
        int longest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastElement) {
                lastElement = arr[i];
                count++;
            } else if (arr[i] == lastElement) {

            } else {
                lastElement = arr[i];
                count = 1;
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }

    /*
     * Optimal Approach - Using Hashset
     * 
     * TC: O(n) + O(2n) ~ O(3n)
     * SC: O(n)
     */
    public static int longestConsecutive(int[] arr) {
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            set.add(val);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int element = arr[i];
                int count = 1;
                while (set.contains(element + 1)) {
                    count++;
                    element++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 4, 200, 1, 3, 2 };

        System.out.print("Longest Consequetive Sequence = " + longestConsecutive(arr));
    }
}
