package BinarySearch;

public class FindNumberOfRotationInSortedArray {
    /*
     * Using Binary search concept
     * 
     * TC: O(logN)
     * SC: O(1)
     */
    public static int findNumberOfRotations(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int numberOfRotation = -1;
        /*
         * number of rotations == index of minimum element in array
         */
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) { // means left half is sorted
                // storing minimum from sorted half
                if (nums[low] < min) {
                    min = nums[low];
                    numberOfRotation = low;
                }
                low = mid + 1; // eliminate it
            } else { // right half is sorted
                // storing minimum from sorted right half
                if (nums[mid] < min) {
                    min = nums[mid];
                    numberOfRotation = mid;
                }
                high = mid - 1; // eliminate right half
            }
        }
        return numberOfRotation;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println("Number of rotation = " + findNumberOfRotations(arr));
    }
}
