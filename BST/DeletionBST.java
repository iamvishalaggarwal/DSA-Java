package BST;

public class DeletionBST {
    public TreeNode findRightMost(TreeNode right) {
        if (right == null) {
            return null;
        }
        while (right.right != null) {
            right = right.right;
        }
        return right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode parent = null;
        TreeNode current = root;

        // Find the node to delete and track its parent
        while (current != null && current.val != key) {
            parent = current;
            current = (key < current.val) ? current.left : current.right;
        }

        // If node is not found, return original root
        if (current == null) {
            return root;
        }

        // Case 1: Node is a leaf (no children)
        if (current.left == null && current.right == null) {
            if (parent == null) { // Deleting the only node in the tree
                return null;
            }
            if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: Node has only a right child
        else if (current.left == null) {
            if (parent == null) {
                return current.right; // Deleting root
            }
            // this condition is used for tracing which side of parent we need to insert
            if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: Node has only a left child
        else if (current.right == null) {
            if (parent == null) {
                return current.left; // Deleting root
            }
            if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 4: Node has two children
        else {
            TreeNode rightMost = findRightMost(current.left); // rightmost child of left part of root
            rightMost.right = current.right;

            if (parent == null) {
                return current.left; // Deleting root
            }
            if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }

        return root;
    }
}