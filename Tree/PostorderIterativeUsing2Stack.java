package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderIterativeUsing2Stack {
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().data);
        }
        return list;
    }
}
