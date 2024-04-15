
import java.util.ArrayList;
import java.util.List;

public class PascalTriange {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long ans = 1;
        list.add((int) ans);
        for (int i = 1; i < rowIndex; i++) {
            ans = (ans * (rowIndex - i)) / i;
            list.add((int) ans);
        }
        return list;
    }

    /*
     * Optimal Approach - Using binomial approach and iterate over each row
     * TC: O(n^2)
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(getRow(i));
        }
        return list;
    }

    public static void main(String[] args) {
        int num = 5;
        List<List<Integer>> pascalTriangle = generate(num);

        for (List<Integer> val : pascalTriangle) {
            System.out.print(val + " ");
        }
    }
}
