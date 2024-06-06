package SlidingWindowProblem;

/*
 * Problem:
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.


Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 */

public class MaxPointsYouCanObtainFromCards {

    /*
     * Intution - phle left side se 'k' elements ka sum krlo, then ek ek krke right
     * side se uthao aur left se htate jao
     * bcz we need to find max score
     * 
     * TC: O(2*K)
     * SC: O(1)
     */
    public static int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int r = cardPoints.length - 1;
        int leftSum = 0;
        while (l < k) {
            leftSum += cardPoints[l];
            l++;
        }

        l--;
        int maxSum = leftSum;
        int rightSum = 0;
        while (l != -1) {
            rightSum += cardPoints[r];
            leftSum -= cardPoints[l];
            maxSum = Math.max(maxSum, leftSum + rightSum);
            r--;
            l--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 32, 69, 37, 79, 4, 33, 29, 33, 45, 1, 99, 90, 56, 24, 76 };
        int k = 10;
        System.out.println("Max score possible = " + maxScore(arr, k));
    }
}
