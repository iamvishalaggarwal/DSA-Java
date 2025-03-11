package BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: You are given the root of a binary search tree (BST), where the
 * values of exactly two nodes of the tree were swapped by mistake. Recover the
 * tree without changing its structure.
 */

/**
 * Brute Force: find inorder -> sort the inorder -> traverse this again while
 * checking tree
 * TC: O(2N) + O(NlogN)
 * SC: O(N)
 */
public class RecoverBST {
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public void inorder(TreeNode root, List<Integer> list, int[] index) {
        if (root == null) {
            return;
        }
        inorder(root.left, list, index);
        if (root.val != list.get(index[0])) {
            root.val = list.get(index[0]);
        }
        index[0]++;
        inorder(root.right, list, index);
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        inorder(root, list, new int[] { 0 });
    }
}
