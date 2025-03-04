package BST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InsertionInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }

        TreeNode temp = root;
        TreeNode prev = null;
        // we just need to make sure that we need to insert the node at the leaf node
        while (temp != null) {
            prev = temp;
            temp = val < temp.val ? temp.left : temp.right;
        }
        if (val < prev.val) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }

        return root;
    }
}
