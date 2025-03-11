package BST;

import java.util.Stack;

// import java.util.ArrayList;

// Brute Force: TC: O(1), SC: O(1)
// class BinarySearchTreeIterator {
//     ArrayList<Integer> list = new ArrayList<>();
//     int value = 0;

//     public BinarySearchTreeIterator(TreeNode root) {
//         inorder(root);
//     }

//     public void inorder(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         inorder(root.left);
//         this.list.add(root.val);
//         inorder(root.right);
//     }

//     public int next() {
//         int val = this.value;
//         this.value++;
//         return val == -1 ? list.get(0) : list.get(val);

//     }

//     public boolean hasNext() {
//         return this.value >= list.size() ? false : true;
//     }
// }

// Optimized using stack storing elements in an iterative way in inorder: TC: O(1), SC: O(H)
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        pushAll(root);
    }

    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {
            this.stack.push(node);
        }
    }
}
