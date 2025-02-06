package TreeNew;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaxDepthOfTree {
    // using level order approach
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        if (root == null) {
            return depth;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode ele = q.remove();
                if (ele.left != null) {
                    q.add(ele.left);
                }
                if (ele.right != null) {
                    q.add(ele.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
