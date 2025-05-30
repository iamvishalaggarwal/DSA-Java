package BST;

/**
 * Given an array of integers arr[] representing inorder traversal of elements
 * of a binary tree. Return true if the given inorder traversal can be of a
 * valid Binary Search Tree.
 * 
 * Note - In a valid Binary Search Tree all keys are unique.
 * 
 * Examples :
 * 
 * Input: arr[] = [8, 14, 45, 64, 100]
 * Output: True
 * 
 * Input: arr[] = [5, 6, 1, 8, 7]
 * Output: False
 */

public class CheckValidBST {
    public boolean isBSTTraversal(int arr[]) {
        // A valid inorder traversal of a BST should be in strictly increasing order for
        // all consecutive elements, so we must check each adjacent pair.
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
