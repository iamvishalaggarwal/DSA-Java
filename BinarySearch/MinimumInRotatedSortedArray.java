package BinarySearch;

public class MinimumInRotatedSortedArray {
    /*
     * Using Binary search concept
     * 
     * TC: O(logN)
     * SC: O(1)
     */
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            /*
             * further optimisation, if the search space is already sorted
             * eg: [4,5,0,1,2]
             * in this type of cases, arr[low] will be smaller
             */
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) { // means left half is sorted
                min = Math.min(min, nums[low]); // storing minimum from sorted half
                low = mid + 1; // eliminate it
            } else { // right half is sorted
                min = Math.min(min, nums[mid]); // storing minimum from sorted right half
                high = mid - 1; // eliminate right half
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println("Minimum = " + findMin(arr));
    }
}
