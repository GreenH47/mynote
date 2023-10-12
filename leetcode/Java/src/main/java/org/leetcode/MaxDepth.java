package org.leetcode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // Base case: if the root is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth of the tree by adding 1 to the maximum of the left and right depths
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
        // Create the binary tree [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepth solution = new MaxDepth();
        int depth = solution.maxDepth(root);

        // Output the maximum depth of the binary tree
        System.out.println("Maximum depth: " + depth);
        // Output: Maximum depth: 3
    }

}
