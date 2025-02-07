package TreeNew;

class TreeNode {
    int val;
    TreeNode left, right;
}

class Tuple {
    TreeNode node;
    int verticalOrder, levelOrder;

    Tuple(TreeNode node, int verticalOrder, int levelOrder) {
        this.node = node;
        this.levelOrder = levelOrder;
        this.verticalOrder = verticalOrder;
    }
}

public class SymmetricTree {

    public boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        // t1 ka left == t2 ka right && t1 a right == t2 ka left
        return (tree1.val == tree2.val) && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }
}
