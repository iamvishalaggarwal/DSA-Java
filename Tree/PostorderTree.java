import java.util.ArrayList;
import java.util.List;

public class PostorderTree {
    public void postorder(TreeNode node, List<Integer> list) {
        // left, right, root
        if (node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.data);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public static void main(String[] args) {

    }
}