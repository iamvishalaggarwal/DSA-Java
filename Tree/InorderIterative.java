import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {

    public List<Integer> inorder(TreeNode root) {
        // algo -
        // use the stack in the same way as we use in the recursion process, we need to
        // store the nodes into stack till the left found
        // and when its null then add into the result list and also check for right node
        // if any
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
