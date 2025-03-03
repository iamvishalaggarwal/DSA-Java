package BST;

public class ValidateBinarySearchTree {
    // Method 1
    public boolean isValidate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        // Ensure current node value is within the allowed range
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        // Recursively validate left and right subtrees
        return isValidate(root.left, min, root.val) && isValidate(root.right, root.val, max);
    }

    // public boolean isValidBST(TreeNode root) {
    // using null values for min and max range for removing limitation
    // Integer.MIN_VALUE and Integer.MAX_VALUE
    // return isValidate(root, null, null);
    // }

    // Method 2
    // but in this we are limited to the range for checking node value 2^31 - 1
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (!(root.val > min && root.val < max)) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
