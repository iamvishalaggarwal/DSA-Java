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

/*
 * Example:
 * Input:
 * inorder[] = [4, 8, 2, 5, 1, 6, 3, 7],
 * postorder[] = [8, 4, 5, 2, 6, 7, 3, 1]
 * 
 * Output: [1, 2, 4, 8, 5, 3, 6, 7]
 */

public class ConstructUniqueBTUsingInorderPostorder {

    public TreeNode convertToTree(int[] postorder, int startIndexPost, int endIndexPost, int[] inorder,
            int startIndexIn, int endIndexIn,
            HashMap<Integer, Integer> inorderMap) {

        if (startIndexPost > endIndexPost || startIndexIn > endIndexIn) {
            return null;
        }

        int rootEleIndex = inorderMap.get(postorder[endIndexPost]);
        TreeNode root = new TreeNode(postorder[endIndexPost]);

        // Number of nodes in the left subtree
        // Note: as we divide the inorder with root, then the number of elements on left
        // should be equal to the number of elements on left of postorder (left, right,
        // root)
        int numsLeft = rootEleIndex - startIndexIn;

        root.right = convertToTree(postorder, startIndexPost + numsLeft, endIndexPost - 1, inorder, rootEleIndex + 1,
                endIndexIn,
                inorderMap);
        root.left = convertToTree(postorder, startIndexPost, startIndexPost + numsLeft - 1, inorder, startIndexIn,
                rootEleIndex - 1,
                inorderMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = convertToTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }
}
