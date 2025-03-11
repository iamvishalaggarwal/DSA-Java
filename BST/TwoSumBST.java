package BST;

import java.util.Stack;

/**
 * Brute Force using hasmap: TC: O(2N), SC: O(N)
 */
// import java.util.HashMap;
// public class TwoSumBST {
// public void inorder(TreeNode root, HashMap<Integer, Integer> map) {
// if (root == null) {
// return;
// }
// inorder(root.left, map);
// map.put(root.val, root.val);
// inorder(root.right, map);
// }

// public boolean findTarget(TreeNode root, int k) {
// HashMap<Integer, Integer> map = new HashMap<>();
// inorder(root, map);
// for (int val : map.keySet()) {
// if (map.containsKey(k - val) && k - val != val) { // Ensure distinct elements
// return true;
// }
// }
// return false;
// }
// }

// using bst iterator + 2 pointer approach
// TC: O(N), SC: O(2H)
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    // reverse = true ==> before
    // reverse = false ==> after
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        if (reverse == false) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k)
                i = l.next();
            else
                j = r.next();
        }
        return false;
    }
}