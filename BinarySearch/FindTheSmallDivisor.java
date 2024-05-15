package BinarySearch;

/**
 * FindTheSmallDivisor
 */
public class FindTheSmallDivisor {

    public static int findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int possibleDivisor(int arr[], int divisor) {
        int sum = 0;
        for (int val : arr) {
            int rem = (int) Math.ceil((double) (val) / (double) (divisor));
            sum += rem;
        }
        return sum;
    }

    // public static int smallestDivisor(int[] nums, int threshold) {
    // for (int i = 1; i <= findMax(nums); i++) {
    // if (possibleDivisor(nums, i) <= threshold) {
    // return i;
    // }
    // }
    // return -1;
    // }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);

        // trick:
        // before impl:-
        // low is considered as not possible case
        // high is considered as possible case
        // after impl:-
        // properties of high and low will swap, i.e., low will be the possible answer
        // and high is not possible answer
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possibleDivisor(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int nums[] = { 44, 22, 33, 11, 1 };
        int threshold = 5;
        System.out.println("Smallest divisor = " + smallestDivisor(nums, threshold));
    }
}