
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Tuple {
    TreeNode node;
    int verticalOrderValue, levelOrderValue;

    public Tuple(TreeNode node, int verticalOrderValue, int levelOrderValue) {
        this.node = node;
        this.verticalOrderValue = verticalOrderValue;
        this.levelOrderValue = levelOrderValue;
    }
}

public class VerticalTraversal {
    // solve using level order approach
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // in this we store: vertical order as key and for value it's a
        // pair of [level (horizontal) order, node value]

        // Note: using priority queue as we need to maintain order of elements while
        // storing it into vertical order
        // suppose we have 10 and 9 on same vertical order,
        // so we need to insert it as [9,10]
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // in this we store:
        // node value, vertical (column-wise) order, level (row-wise) order
        Queue<Tuple> q = new LinkedList<Tuple>();

        // Push the root node with initial vertical
        // and level values (0, 0)
        q.add(new Tuple(root, 0, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            TreeNode node = tuple.node;
            int verticalOrderValue = tuple.verticalOrderValue;
            int levelOrderValue = tuple.levelOrderValue;

            if (!map.containsKey(verticalOrderValue)) {
                map.put(verticalOrderValue, new TreeMap<>());
            }

            if (!map.get(verticalOrderValue).containsKey(levelOrderValue)) {
                map.get(verticalOrderValue).put(levelOrderValue, new PriorityQueue<>());
            }

            map.get(verticalOrderValue).get(levelOrderValue).add(node.val);

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

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> verticalOrderVal : map.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : verticalOrderVal.values()) {
                while (!nodes.isEmpty()) {
                    result.get(result.size() - 1).add(nodes.remove());
                }
            }
        }
        return result;
    }
}
