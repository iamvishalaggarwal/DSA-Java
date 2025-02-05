package TreeNew;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

public class PostorderTraversalUsing1Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode node = root;
        st1.push(node);

        while (!st1.isEmpty()) {
            node = st1.pop();
            st2.push(node);

            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }

        while (!st2.isEmpty()) {
            result.add(st2.pop().val);
        }
        return result;
    }
}
