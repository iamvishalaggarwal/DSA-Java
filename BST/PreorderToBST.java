package BST;

public class PreorderToBST {
    // public TreeNode insertBST(TreeNode root, int val) {
    // if (root == null) {
    // return new TreeNode(val);
    // }
    // if (val < root.val) {
    // root.left = insertBST(root.left, val);
    // } else {
    // root.right = insertBST(root.right, val);
    // }
    // return root;
    // }

    // // Brute force - insert one by one
    // // Constructs BST from the given Preorder Traversal
    // public TreeNode bstFromPreorder(int[] preorder) {
    // TreeNode root = null;
    // for (int val : preorder) {
    // root = insertBST(root, val);
    // }
    // return root;
    // }

    // public TreeNode convertToTree(int[] preorder, HashMap<Integer, Integer>
    // inorderMap,
    // int startIn, int endIn, int startPre, int endPre) {
    // if (startIn > endIn || startPre > endPre) {
    // return null;
    // }

    // int reqIndex = inorderMap.get(preorder[startPre]);
    // int numsLeft = reqIndex - startIn;
    // TreeNode root = new TreeNode(preorder[startPre]);

    // root.left = convertToTree(preorder, inorderMap, startIn, reqIndex - 1,
    // startPre + 1, startPre + numsLeft);
    // root.right = convertToTree(preorder, inorderMap, reqIndex + 1, endIn,
    // startPre + numsLeft + 1, endPre);
    // return root;
    // }

    // // approach 2 - using inorder & preorder
    // public TreeNode bstFromPreorder(int[] preorder) {
    // List<Integer> inorder = new ArrayList<>();
    // for (int num : preorder) {
    // inorder.add(num);
    // }
    // Collections.sort(inorder); // after sorting preorder becomes inorder

    // HashMap<Integer, Integer> inorderMap = new HashMap<>();
    // for (int i = 0; i < inorder.size(); i++) {
    // inorderMap.put(inorder.get(i), i);
    // }

    // return convertToTree(preorder, inorderMap, 0, inorder.size() - 1, 0,
    // preorder.length - 1);
    // }

    // approach 3 - using range (the way which we use in validation of BST)
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        // using only upper bound and for pointer using this single element array
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }
}
