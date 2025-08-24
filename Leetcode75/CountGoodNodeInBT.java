package Leetcode75;

class Solution {
    private int helper(TreeNode root, int ans, int currMax) {
        if (root == null) {
            return 0;
        }

        int rootAnswer = 0;
        if (root.val >= currMax) {
            rootAnswer = 1;
            currMax = root.val;
        }

        int lans = helper(root.left, ans, currMax);
        int rans = helper(root.right, ans, currMax);
        return lans + rans + rootAnswer;
    }

    public int goodNodes(TreeNode root) {
        return helper(root, 0, Integer.MIN_VALUE);
    }
}
