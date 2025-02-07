package TreeNew;

import java.util.ArrayList;

public class RootToNodePath {
    public static boolean findPaths(Node root, ArrayList<Integer> list, int val) {
        if (root == null) {
            return false;
        }
        list.add(root.data);
        if (root.data == val) {
            return true;
        }
        if (findPaths(root.left, list, val) || findPaths(root.right, list, val)) {
            return true;
        }
        list.remove(list.size() - 1); // removing last element
        return false;
    }

    public static ArrayList<Integer> Paths(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        int nodeVal = 5;
        if (root == null) {
            return result;
        }
        findPaths(root, result, nodeVal);
        return result;
    }
}
