package TreeNew;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SerializeAndDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                str.append("#,");
                continue;
            }
            str.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] strList = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strList[0]));
        q.add(root);
        for (int i = 1; i < strList.length; i++) {
            TreeNode parent = q.remove();
            // skipping '#' values for null values indication
            if (!strList[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(strList[i]));
                parent.left = left;
                q.add(left);
            }

            // increasing 'i' here as well for getting right child
            if (!strList[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strList[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
