package TreeNew;

class TreeNode {
    int data;
    TreeNode leftNode, rightNode;

    TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}

public class RepresentationOfTreeInJava {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.leftNode = new TreeNode(1);
        root.rightNode = new TreeNode(2);
    }
}
