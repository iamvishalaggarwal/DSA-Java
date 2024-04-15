
import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        // right --> bottom --> left --> top

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, top = 0, right = n - 1, bottom = m - 1;

        while (left <= right && top <= bottom) {
            // For moving left to right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiral;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Before = ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Spiral Matrix - ");
        for (int val : spiralOrder(matrix)) {
            System.out.print(val + " ");
        }
    }
}
