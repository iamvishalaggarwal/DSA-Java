import java.util.ArrayList;
import java.util.Stack;

/**
 * PreorderInorderPostorderInOneTraversal
 */
public class PreorderInorderPostorderInOneTraversal {

    static class Pair {
        Node first;
        int second;

        public Pair(Node first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Structure of the
    // node of a binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    };

    // Function to print all nodes of a
    // binary tree in Preorder, Postorder
    // and Inorder using only one stack
    static void allTraversal(Node root) {

        // Stores preorder traversal
        ArrayList<Integer> pre = new ArrayList<>();

        // Stores inorder traversal
        ArrayList<Integer> in = new ArrayList<>();

        // Stores postorder traversal
        ArrayList<Integer> post = new ArrayList<>();

        // Stores the nodes and the order
        // in which they are currently visited
        Stack<Pair> s = new Stack<>();

        // Push root node of the tree
        // into the stack
        s.push(new Pair(root, 1));

        // Traverse the stack while
        // the stack is not empty
        while (!s.empty()) {

            // Stores the top
            // element of the stack
            Pair p = s.peek();

            // If the status of top node
            // of the stack is 1
            if (p.second == 1) {

                // Update the status
                // of top node
                s.peek().second++;

                // Insert the current node
                // into preorder, pre[]
                pre.add(p.first.data);

                // If left child is not null
                if (p.first.left != null) {

                    // Insert the left subtree
                    // with status code 1
                    s.push(new Pair(p.first.left, 1));
                }
            }

            // If the status of top node
            // of the stack is 2
            else if (p.second == 2) {

                // Update the status
                // of top node
                s.peek().second++;

                // Insert the current node
                // in inorder, in[]
                in.add(p.first.data);

                // If right child is not null
                if (p.first.right != null) {

                    // Insert the right subtree into
                    // the stack with status code 1
                    s.push(new Pair(p.first.right, 1));
                }
            }

            // If the status of top node
            // of the stack is 3
            else {

                // Push the current node
                // in post[]
                post.add(p.first.data);

                // Pop the top node
                s.pop();
            }
        }
    }
}