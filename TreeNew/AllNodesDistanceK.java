package TreeNew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceK {

    public void parentMapping(TreeNode root, HashMap<TreeNode, TreeNode> parentsMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    parentsMap.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parentsMap.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, TreeNode> parentsMap = new HashMap<>();
        if (root == null) {
            return result;
        }
        if (k == 0) {
            result.add(target.val);
            return result;
        }

        parentMapping(root, parentsMap);

        HashMap<TreeNode, Boolean> visitedNodesMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        visitedNodesMap.put(target, true);
        int current_distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            current_distance++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                if (node.left != null && !visitedNodesMap.containsKey(node.left)) {
                    visitedNodesMap.put(node.left, true);
                    q.add(node.left);
                }

                if (node.right != null && !visitedNodesMap.containsKey(node.right)) {
                    visitedNodesMap.put(node.right, true);
                    q.add(node.right);
                }

                if (parentsMap.get(node) != null && !visitedNodesMap.containsKey(parentsMap.get(node))) {
                    visitedNodesMap.put(parentsMap.get(node), true);
                    q.add(parentsMap.get(node));
                }
            }
            if (current_distance >= k) {
                break;
            }
        }
        if (current_distance == k) {
            while (!q.isEmpty()) {
                result.add(q.remove().val);
            }
        }
        return result;
    }
}
