package TreeNew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tuple {
    Node node;
    int verticalOrderValue, levelOrderValue;

    public Tuple(Node node, int verticalOrderValue, int levelOrderValue) {
        this.node = node;
        this.verticalOrderValue = verticalOrderValue;
        this.levelOrderValue = levelOrderValue;
    }
}

public class TopView {
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(root, 0, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            Node node = tuple.node;
            int verticalOrderValue = tuple.verticalOrderValue;
            int levelOrderValue = tuple.levelOrderValue;

            if (!map.containsKey(verticalOrderValue)) {
                map.put(verticalOrderValue, node.data);
            }

            // level always increases if we moves down
            // when moving towards left vertical order decreases, and we suppose
            // vertical order of root = 0, so on left it is -1,-2,-3...so on
            if (node.left != null) {
                q.add(new Tuple(node.left, verticalOrderValue - 1, levelOrderValue + 1));
            }

            // when moving towards right vertical order increases, and we suppose
            // vertical order of root = 0, so on right it is 1,2,3...so on
            if (node.right != null) {
                q.add(new Tuple(node.right, verticalOrderValue + 1, levelOrderValue + 1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int nodeValues : map.values()) {
            result.add(nodeValues);
        }
        return result;
    }
}
