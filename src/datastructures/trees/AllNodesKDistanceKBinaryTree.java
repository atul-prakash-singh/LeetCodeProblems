package datastructures.trees;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesKDistanceKBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);

        System.out.println(distanceK(tree.root, new TreeNode(7), 1));
    }

    private static final Map<TreeNode, Integer> map = new HashMap<>();

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

    private static void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }
        if (root == target) {
            map.put(root, 0);
            return;
        }
        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }
        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
        }
    }

    public static void search(TreeNode root, int dis, int K, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            dis = map.get(root);
        }
        if (dis == K) {
            res.add(root.val);
        }
        search(root.left, dis + 1, K, res);
        search(root.right, dis + 1, K, res);
    }
}
