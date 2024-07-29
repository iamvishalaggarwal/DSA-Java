package Tree;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
    public void inorder(TreeNode node, List<Integer> list) {
        // left, root, right
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
}
