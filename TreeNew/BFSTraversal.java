package TreeNew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode leftNode, rightNode;

    TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    /**
     * Approach - take one Q's and one nested array list (R1) in which in first
     * initially
     * in Q1 we store the root
     * node and check if left or right exist, if exists then add it in the Q1. Now
     * when this is done, remove this node from Q1 and add this in R1
     * repeat this process unit Q1 is not empty!
     */
    public List<List<Integer>> bfs(TreeNode node) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();

        List<List<Integer>> resultant = new ArrayList<>();

        if (node == null)
            return resultant;

        q1.add(node);

        while (!q1.isEmpty()) {
            int size = q1.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q1.remove();

                if (currNode.leftNode != null)
                    q1.add(currNode.leftNode);

                if (currNode.rightNode != null)
                    q1.add(currNode.rightNode);

                temp.add(currNode.data);
            }

            resultant.add(temp);
        }

        return resultant;
    }

}

public class BFSTraversal {

}
