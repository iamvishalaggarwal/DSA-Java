import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderIterativeUsing1Stack {

    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    list.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
