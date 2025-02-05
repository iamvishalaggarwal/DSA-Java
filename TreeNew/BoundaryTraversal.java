package TreeNew;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BoundaryTraversal {

    void preorder(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(node.data);
            return;
        }
        preorder(node.left, result);
        preorder(node.right, result);
    }

    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        if (!(node.left == null && node.right == null)) { // add root if not leaf
            result.add(node.data);
        }

        // left boundary
        Node curr = node.left;
        while (curr != null) {
            if (!(curr.left == null && curr.right == null)) { // check for leaf node
                result.add(curr.data);
            }
            if (curr.left != null)
                curr = curr.left;
            else {
                curr = curr.right;
            }
        }

        // for finding leaf nodes
        preorder(node, result);

        // for right boundary
        ArrayList<Node> list = new ArrayList<>();
        curr = node.right;
        while (curr != null) {
            if (!(curr.left == null && curr.right == null)) { // check for leaf node
                list.add(curr);
            }
            if (curr.right != null)
                curr = curr.right;
            else {
                curr = curr.left;
            }
        }

        // inserting in stack
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i).data);
        }

        return result;
    }
}
