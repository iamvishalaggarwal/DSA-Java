import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithXorK {

    /*
     * Brute Force: keeping track of all subarrays and calc xor of them
     * 
     * TC: O(n^2)
     * SC: O(1)
     */
    // public static int getNumberOfSubarraysWithXorK(int arr[], int k) {
    // int count = 0;
    // for (int i = 0; i < arr.length; i++) {
    // int xor = 0;
    // for (int j = i; j < arr.length; j++) {
    // xor ^= arr[j];
    // if (xor == k) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    /*
     * Optimal: Using Prefix XOR (and HashMap)
     * TC: O(N)
     * SC: O(N)
     */
    public static int getNumberOfSubarraysWithXorK(int arr[], int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        // default xor, (for k^k case)
        map.put(xr, 1);

        for (int val : arr) {
            xr = xr ^ val;

            if (map.containsKey(xr)) {
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }

            // by formula, finding prefix XOR
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println("Subarray length = " + getNumberOfSubarraysWithXorK(arr, k));
    }
}
