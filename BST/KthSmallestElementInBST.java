package BST;

import java.util.ArrayList;

public class KthSmallestElementInBST {
    // // brute force approach - traversing tree using DFS
    // public int kthSmallest(TreeNode root, int k) {
    // Queue<TreeNode> q = new LinkedList<>();
    // ArrayList<Integer> list = new ArrayList<>();
    // q.add(root);
    // while(!q.isEmpty()) {
    // int size = q.size();
    // for(int i=0; i<size; i++) {
    // TreeNode node = q.remove();
    // list.add(node.val);
    // if(node.left != null) {
    // q.add(node.left);
    // }
    // if(node.right != null) {
    // q.add(node.right);
    // }
    // }
    // }
    // Collections.sort(list);
    // return list.get(k-1);
    // }

    // using inorder - because inorder of BST is sorted order of nodes always
    public void inorder(TreeNode root, ArrayList<Integer> list, int k) {
        if (root == null || list.size() == k) {
            return;
        }
        inorder(root.left, list, k);
        list.add(root.val);
        inorder(root.right, list, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k - 1);
    }

}