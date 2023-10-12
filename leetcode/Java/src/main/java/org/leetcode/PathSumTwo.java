package org.leetcode;
import java.util.*;
public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, paths);
        return paths;

    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, targetSum - node.val, currentPath, paths);
            dfs(node.right, targetSum - node.val, currentPath, paths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        PathSumTwo solution = new PathSumTwo();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        int targetSum1 = 22;
        List<List<Integer>> result1 = solution.pathSum(root1, targetSum1);
        System.out.println("Path Sum 1: " + result1); // Expected output: [[5,4,11,2],[5,8,4,5]]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        int targetSum2 = 5;
        List<List<Integer>> result2 = solution.pathSum(root2, targetSum2);
        System.out.println("Path Sum 2: " + result2); // Expected output: []

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        int targetSum3 = 0;
        List<List<Integer>> result3 = solution.pathSum(root3, targetSum3);
        System.out.println("Path Sum 3: " + result3); // Expected output: []

    }
}
