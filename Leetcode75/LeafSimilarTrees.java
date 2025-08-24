package Leetcode75;

import java.util.*;

class Solution {

    public void preorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        preorder(root1, list1);
        preorder(root2, list2);
        return list1.equals(list2);
    }
}
