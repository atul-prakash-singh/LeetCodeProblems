package datastructures.trees;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {

    private static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
