package BST;

public class FloorBST {
    public static int floor(Node root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data;
            }

            if (x > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
