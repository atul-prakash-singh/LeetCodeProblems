package datastructures.trees;

//https://leetcode.com/problems/univalued-binary-tree/
public class UnivaluedBinaryTree {

    private int val = 0;

    private boolean isUnivalTree(TreeNode root) {
        val = root.val;
        return sameValue(root);
    }

    private boolean sameValue(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return sameValue(root.left) && sameValue(root.right);
    }
}
