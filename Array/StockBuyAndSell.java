
public class StockBuyAndSell {

    /*
     ** Brute Force Approach
     ** TC: O(n*n)
     ** SC: O(1)
     * public static int maxProfit(int[] prices) {
     * int profit = 0;
     * int val = 0;
     * for (int i = 0; i < prices.length; i++) {
     * for (int j = i + 1; j < prices.length; j++) {
     * val = prices[j] - prices[i];
     * if (val > profit) {
     * profit = val;
     * }
     * }
     * }
     * return profit;
     * }
     */

    /**
     * Optimal Approach
     * TC: O(n)
     * SC: O(1)
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(prices[i], min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 0, 1, 5, 3, 6, 4, 0 };
        System.out.print("Maximum Profit = " + maxProfit(arr));
    }
}
