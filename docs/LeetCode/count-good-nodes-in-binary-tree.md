[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75)  
Given a binary tree `root`, a node _X_ in the tree is named **good** if in the path from root to _X_ there are no nodes with a value _greater than_ X.  
给定一个二叉树，如果从根到X的路径中没有值大于X的节点，则树 `root` 中的节点X被命名为好。

Return the number of **good** nodes in the binary tree.  
返回二叉树中良好节点的数量。

**Example 1: 示例 1：**

**![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_1.png)**

**Input:** root = [3,1,4,3,null,1,5]
**Output:** 4
**Explanation:** Nodes in blue are **good**.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

**Example 2: 示例 2：**

**![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_2.png)**

**Input:** root = [3,3,null,4,2]
**Output:** 3
**Explanation:** Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

**Example 3: 例3：**

**Input:** root = [1]
**Output:** 1
**Explanation:** Root is considered as **good**.

**Constraints: 约束：**

- The number of nodes in the binary tree is in the range `[1, 10^5]`.  
    二叉树中的节点数在 `[1, 10^5]` 范围内。
- Each node's value is between `[-10^4, 10^4]`.  
    每个节点的值介于 `[-10^4, 10^4]` .