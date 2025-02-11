package TreeNew;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Burning Tree or Infectious tree
public class MinTimeTakenToBurnTreeFromNode {

    public static Node parentsMappingandGetTargetNode(Node root, int targetVal, HashMap<Node, Node> parentsMap) {
        Node target = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.remove();

                if (node.left != null) {
                    parentsMap.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parentsMap.put(node.right, node);
                    q.add(node.right);
                }
                if (node.data == targetVal) {
                    target = node;
                }
            }
        }
        return target;
    }

    public static int minTime(Node root, int target) {
        HashMap<Node, Node> parentsMap = new HashMap<>();
        Node targetNode = parentsMappingandGetTargetNode(root, target, parentsMap);
        if (targetNode == null) {
            return 0;
        }
        int time_taken = -1; // find time with zero indexing
        HashMap<Node, Boolean> visitedNodesMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);

        visitedNodesMap.put(targetNode, true);

        while (!q.isEmpty()) {
            int size = q.size();
            time_taken++;
            for (int i = 0; i < size; i++) {
                Node node = q.remove();
                if (node.left != null && !visitedNodesMap.containsKey(node.left)) {
                    q.add(node.left);
                    visitedNodesMap.put(node.left, true);
                }
                if (node.right != null && !visitedNodesMap.containsKey(node.right)) {
                    q.add(node.right);
                    visitedNodesMap.put(node.right, true);
                }
                if (parentsMap.containsKey(node) && !visitedNodesMap.containsKey(parentsMap.get(node))) {
                    q.add(parentsMap.get(node));
                    visitedNodesMap.put(parentsMap.get(node), true);
                }
            }
        }
        return time_taken;
    }
}
