package TreeNew;

class TreeNode {
    int data;
    TreeNode leftNode, rightNode;

    TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.leftNode);
        System.out.println(node.data);
        inorder(node.rightNode);
    }

    public void postorder(TreeNode node) {
        if (node == null)
            return;
        postorder(node.leftNode);
        postorder(node.rightNode);
        System.out.println(node.data);
    }

    public void preorder(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preorder(node.leftNode);
        preorder(node.rightNode);
    }
}

public class DFSTraversal {
    public static void main(String[] args) {

    }
}
