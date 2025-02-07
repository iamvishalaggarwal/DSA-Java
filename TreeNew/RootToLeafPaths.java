package TreeNew;

import java.util.ArrayList;

public class RootToLeafPaths {
    public static void findPaths(Node root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(list)); // clone the list as we need to preserve this list
        }
        findPaths(root.left, result, list);
        findPaths(root.right, result, list);
        list.remove(list.size() - 1); // removing last element
        return;
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPaths(root, result, new ArrayList<Integer>());
        return result;
    }
}
