[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/path-sum-ii/)  
Given the `root` of a binary tree and an integer `targetSum`, return _all **root-to-leaf** paths where the sum of the node values in the path equals_ `targetSum`_. Each path should be returned as a list of the node **values**, not node references_.  
`root` 给定二叉树和整数 `targetSum` 的 ，返回路径中节点值之和等于 `targetSum` 的所有根到叶路径。每个路径都应作为节点值的列表返回，而不是节点引用。

A **root-to-leaf** path is a path starting from the root and ending at any leaf node. A **leaf** is a node with no children.  
根到叶路径是从根开始并在任何叶节点结束的路径。叶是没有子节点的节点。

**Example 1: 示例 1：**

![](https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg)

**Input:** root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
**Output:** [[5,4,11,2],[5,8,4,5]]
**Explanation:** There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

**Example 2: 示例 2：**

![](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)

**Input:** root = [1,2,3], targetSum = 5
**Output:** []

**Example 3: 例3：**

**Input:** root = [1,2], targetSum = 0
**Output:** []

**Constraints: 约束：**

- The number of nodes in the tree is in the range `[0, 5000]`.  
    树中的节点数在 `[0, 5000]` 范围内。
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`
