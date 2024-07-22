import java.util.ArrayList;
import java.util.List;

public class PreorderTree {
    public static void preorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.data);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        return arr;
    }

    public static void main(String[] args) {

    }
}
