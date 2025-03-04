package BST;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class CeilInBST {
    int findCeil(Node root, int key) {
        if (root == null)
            return -1;

        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data > key) {
                ceil = root.data; // update ceil before moving left
            }
            root = key < root.data ? root.left : root.right;
        }

        return ceil;
    }
}
