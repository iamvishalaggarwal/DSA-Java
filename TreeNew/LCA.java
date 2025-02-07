package TreeNew;

import java.util.ArrayList;

// lowest common ancestor
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia:“The lowest common ancestor is defined between 
// two nodes p and q as the lowest node in T that has both p and q as descendants(where we allow a node to be a descendant of itself).”

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LCA {

    public static boolean findPaths(TreeNode root, ArrayList<TreeNode> list, TreeNode node) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root == node) {
            return true;
        }
        if (findPaths(root.left, list, node) || findPaths(root.right, list, node)) {
            return true;
        }
        list.remove(list.size() - 1); // removing last element
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /**
         * basically isme hume given node tak ka path nikalna hai, and uss path mai se
         * common value [i.e., ancestor which is at the deepest level (lowest level)]
         * nikalni hai, jo sbse last mai common rhegi whi LCA hoga!
         * 
         * BUT: this approach is taking O(N + N) ie, extra space
         */
        ArrayList<TreeNode> pathOfP = new ArrayList<>();
        ArrayList<TreeNode> pathOfQ = new ArrayList<>();

        if (root == null) {
            return null;
        }

        findPaths(root, pathOfP, p);
        findPaths(root, pathOfQ, q);

        TreeNode minNode = null;

        for (TreeNode node1 : pathOfP) {
            for (TreeNode node2 : pathOfQ) {
                if (node1.val == node2.val) {
                    minNode = node1;
                }
            }
        }
        return minNode; // LCA
    }

    // optimized
    // not using any auxiliary space for storing paths of p and q
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
