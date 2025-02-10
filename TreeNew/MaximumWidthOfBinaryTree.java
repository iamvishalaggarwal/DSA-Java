package TreeNew;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    TreeNode node;
    int idx;

    Tuple(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

/**
 * Need to allocate index to all the nodes, and once we allocate then it will be
 * done, and we can find number of nodes = last_index - first_index + 1
 * for index calc:
 * - for left index = 2*i+1, where i is the parent index
 * - for right index = 2*i+2
 */

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }

        q.add(new Tuple(root, 0));
        int width = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int idx1 = 0, idx2 = 0;
            int mmin = q.peek().idx; // for preventing overflow issue in case of skewed trees, normalizing index by
            // subtracting min index
            // of previous level in current level nodes
            for (int i = 0; i < size; i++) {
                Tuple tuple = q.remove();
                TreeNode node = tuple.node;
                int idx = tuple.idx - mmin;

                if (node.left != null) {
                    q.add(new Tuple(node.left, 2 * idx + 1)); // for left index = 2*i+1, where i is the parent index
                }
                if (node.right != null) {
                    q.add(new Tuple(node.right, 2 * idx + 2)); // for right index = 2*i+2
                }

                if (i == 0)
                    idx1 = idx;
                if (i == size - 1)
                    idx2 = idx;
            }
            width = Math.max(width, idx2 - idx1 + 1);
        }
        return width;
    }
}
