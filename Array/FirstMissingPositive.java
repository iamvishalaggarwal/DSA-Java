import java.util.HashMap;

public class FirstMissingPositive {
    /*
     * Brute force
     */
    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            max = Math.max(val, max);
        }

        // when we have all negative numbers array
        if (max < 0) {
            return 1;
        }

        for (int i = 1; i < max; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int nums[] = { -5 };
        System.out.println("first missing positive = " + firstMissingPositive(nums));
    }
}
