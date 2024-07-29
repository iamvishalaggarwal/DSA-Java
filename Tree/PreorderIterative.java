package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {

    public List<Integer> preorder(TreeNode root) {
        // preorder - root, left, right

        // as we are using stack so we first we need to add the root and then
        // first need to add the right node then the left node
        // as we need to add left node first (it will be on top if we add it into last)
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.data);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
