[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/4sum/)  
iven an array `nums` of `n` integers, return _an array of all the **unique** quadruplets_ `[nums[a], nums[b], nums[c], nums[d]]` such that:  
给定一个 `n` 整数数组，返回一个包含所有唯一四胞胎 `[nums[a], nums[b], nums[c], nums[d]]` 的数组 `nums` ，使得：

- `0 <= a, b, c, d < n`
- `a`, `b`, `c`, and `d` are **distinct**.  
    `a` 、 `b` `c` 和 `d` 是不同的。
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.  
您可以按任何顺序返回答案。

**Example 1: 示例 1：**

**Input:** nums = [1,0,-1,0,-2,2], target = 0
**Output:** [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

**Example 2: 示例 2：**

**Input:** nums = [2,2,2,2,2], target = 8
**Output:** [[2,2,2,2]]

**Constraints: 约束：**

- `1 <= nums.length <= 200`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`