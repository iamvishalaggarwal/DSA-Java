package TreeNew;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    /**
     * brute force approach- traverse all nodes
     */
    // public int countNodes(TreeNode root) {
    // Queue<TreeNode> q = new LinkedList<>();
    // if (root == null) {
    // return 0;
    // }
    // q.add(root);
    // int count = 0;
    // while (!q.isEmpty()) {
    // int size = q.size();
    // for (int i = 0; i < size; i++) {
    // count++;
    // TreeNode node = q.remove();
    // if (node.left != null) {
    // q.add(node.left);
    // }
    // if (node.right != null) {
    // q.add(node.right);
    // }
    // }
    // }
    // return count;
    // }

    /**
     * optimized intution:
     * if we have full binary tree we can count the number of nodes,
     * using formula: 2^h - 1
     * and if we check that the tree is full binary tree or not we can ease our
     * work, we can simply check this by calculating left and right height of tree,
     * if l == h, then it is full binary tree, else (l<h) we can move to left or
     * right subtree for checking them in a recursive way
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = leftHeightOfTree(root);
        int rh = rightHeightOfTree(root);

        if (lh == rh) {
            return (int) ((Math.pow(2, lh)) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeightOfTree(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightHeightOfTree(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
