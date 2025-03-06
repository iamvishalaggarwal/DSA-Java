package BST;

public class LCAInBST {

    /*
     * here, we have following possibilities:
     * - both p & q on left
     * - both p & q on right
     * - p on left & q on right
     * - q on right & q on left
     * 
     * so, when the both on different side then path splits and we can say that
     * point as LCA
     * and is they on same side then we can move to that side and continue the
     * search
     * and
     * if the current node is equal to p or q then we can return that node as LCA
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int curr = root.val;
        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
