package BST;

import java.util.ArrayList;

/**
 * You are given root node of the BST and an integer key.
 * You need to find the in-order successor and predecessor of the given key. If
 * either predecessor or successor is not found, then set it to NULL.
 * 
 * Note:- In an inorder traversal the number just smaller than the target is the
 * predecessor
 * and the number just greater than the target is the successor.
 * 
 * NOTE: if the key is not found, then we should also need to find the pre and
 * suc
 */
public class PredecessorAndSuccessor {

    public static void inorder(Node root, ArrayList<Node> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        ArrayList<Node> list = new ArrayList<>();
        inorder(root, list);

        int reqIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).data == key) {
                reqIndex = i;
                break;
            }
        }

        // NOTE: if the key is not found,
        // then we should also need to find the pre and suc
        if (reqIndex == -1) { // Key not found, determine the closest pre and suc
            pre[0] = null;
            suc[0] = null;
            for (Node node : list) {
                if (node.data < key) {
                    pre[0] = node;
                } else if (node.data > key) {
                    suc[0] = node;
                    break;
                }
            }
        } else {
            pre[0] = (reqIndex > 0) ? list.get(reqIndex - 1) : null;
            suc[0] = (reqIndex < list.size() - 1) ? list.get(reqIndex + 1) : null;
        }
    }
}