public class FindElementInPascalTriangle {

    // Calculating nCr (combinaion formula in maths)
    public static int nCr(int n, int r) {
        int result = 1;
        for (int i = 1; i <= r; i++) {
            result = (result * n) / i;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        System.out.print("Element in pascal triangle = " + nCr(row - 1, col - 1));
    }
}
