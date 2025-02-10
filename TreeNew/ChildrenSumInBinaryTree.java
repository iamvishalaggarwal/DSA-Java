package TreeNew;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class ChildrenSumInBinaryTree {
    public static int isSumProperty(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int sum = 0;
                Node node = q.remove();
                if (node.left == null && node.right == null) {
                    continue;
                }
                if (node.left != null) {
                    q.add(node.left);
                    sum += node.left.data;
                }
                if (node.right != null) {
                    q.add(node.right);
                    sum += node.right.data;
                }

                if (sum != node.data) {
                    return 0;
                }
            }
        }
        return 1;
    }

}
