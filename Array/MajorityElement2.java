
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {

    /*
     * Approach - Using Hashmap
     * TC: O(N logN)
     * SC: O(1)
     */
    public static List<Integer> majorityElementWithNBy3(int[] arr) {
        List<Integer> list = new ArrayList<>();
        double threshold = Math.floor(arr.length / 3);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : arr) {
            int count = map.getOrDefault(val, 0) + 1;
            map.put(val, count);
            if (count > threshold) {
                if (!list.contains(val)) {
                    list.add(val);
                }
            }
            /*
             ** Observation:
             ** for example: n = 8
             ** floor(n/3) = 3
             ** So, we have > 3 elements, which means there can be only 2 elements in
             * array
             ** (Since, 3 + 3 + 3 --> 9 which is not possible)
             * same we can check for any other number
             * Hence, there can be only at max 2 majority elements
             */
            if (list.size() == 2) {
                break;
            }
        }
        return list;
    }

    /*
     * Optimal Approach - Using Moore's Algo
     * 
     * TC: O(2n)
     * SC: O(1)
     */
    public static List<Integer> majorityElements(int[] arr) {
        List<Integer> list = new ArrayList<>();

        // using boyer moore's algo
        // if koi majority nhi ho skta, to use remove krne ke liye utne negative log
        // hone chahiye humpe
        // isme jo count ayega usse mtlb nhi tha hume
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && arr[i] != element2) {
                element1 = arr[i];
                count1++;
            } else if (count2 == 0 && arr[i] != element1) {
                element2 = arr[i];
                count2++;
            } else if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // for checking that,
        // the element which we found are really majority element or not
        int cnt1 = 0, cnt2 = 0;
        for (int val : arr) {
            if (val == element1)
                cnt1++;
            if (val == element2)
                cnt2++;
        }

        // insert into list after checking n/3 condition
        if (cnt1 > arr.length / 3)
            list.add(element1);
        if (cnt2 > arr.length / 3)
            list.add(element2);

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.print("Majority element = " + majorityElements(arr));
    }
}
