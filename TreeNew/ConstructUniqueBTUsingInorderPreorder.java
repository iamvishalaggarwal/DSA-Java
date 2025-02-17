package TreeNew;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConstructUniqueBTUsingInorderPreorder {

    public TreeNode convertToTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> mapOfInorder,
            int startIndexOfInorder, int endIndexOfInorder,
            int startIndexOfPreorder, int endIndexOfPreorder) {

        if (startIndexOfPreorder > endIndexOfPreorder || startIndexOfInorder > endIndexOfInorder) {
            return null;
        }

        int reqIndex = mapOfInorder.get(preorder[startIndexOfPreorder]);
        int numsLeft = reqIndex - startIndexOfInorder;
        TreeNode root = new TreeNode(preorder[startIndexOfPreorder]);

        root.left = convertToTree(preorder, inorder, mapOfInorder, startIndexOfInorder, reqIndex - 1,
                startIndexOfPreorder + 1,
                startIndexOfPreorder + numsLeft);

        root.right = convertToTree(preorder, inorder, mapOfInorder, reqIndex + 1, endIndexOfInorder,
                startIndexOfPreorder + numsLeft + 1,
                endIndexOfPreorder);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mapOfInorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapOfInorder.put(inorder[i], i);
        }
        TreeNode root = convertToTree(preorder, inorder, mapOfInorder, 0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }
}
