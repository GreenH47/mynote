[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/combinations/)  
Given two integers `n` and `k`, return _all possible combinations of_ `k` _numbers chosen from the range_ `[1, n]`.  
给定两个整数 `n` 和 `k` ，返回从范围 `[1, n]` 中选择 `k` 的所有可能的数字组合。

You may return the answer in **any order**.  
您可以按任何顺序返回答案。

**Example 1: 示例 1：**

**Input:** n = 4, k = 2
**Output:** [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
**Explanation:** There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

**Example 2: 示例 2：**

**Input:** n = 1, k = 1
**Output:** [[1]]
**Explanation:** There is 1 choose 1 = 1 total combination.

**Constraints: 约束：**

- `1 <= n <= 20`
- `1 <= k <= n`

```python
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        results = []  # List to store the combinations
        current = []  # List to store the current combination

        def track(start,current):
            if len(current) == k:
                results.append(current[:])
                return

            for i in range(start, n + 1):
                current.append(i)
                track(i + 1, current)
                current.pop()

        track(1, current)

        return results

```

1. Create an empty list `result` to store the combinations and an empty list `current` to store the current combination.  
    创建一个空列表来存储组合，创建一个空列表 `result` `current` 来存储当前组合。
2. Define a helper function `backtrack` that takes a starting number and the current combination as arguments.  
    定义一个帮助程序函数，该函数 `backtrack` 将起始数字和当前组合作为参数。
3. If the length of the current combination is equal to `k`, add a copy of the current combination to the `result` list.  
    如果当前组合的长度等于 `k` ，则将当前组合的副本添加到 `result` 列表中。
4. Otherwise, iterate from the starting number to `n` (inclusive) and do the following:  
    否则，从起始编号迭代到 `n` （含）并执行以下操作：
    - Add the current number to the `current` combination.  
        将当前数字添加到组合中 `current` 。
    - Recursively call the `backtrack` function with the next number as the starting number.  
        递归调用函数， `backtrack` 将下一个数字作为起始数字。
    - After the recursive call, remove the last element from the `current` combination to backtrack.  
        递归调用后，从 `current` 组合中删除最后一个元素以进行回溯。
5. Call the `backtrack` function initially with a starting number of 1 and an empty `current` combination.  
    最初使用起始编号 1 和空 `current` 组合调用 `backtrack` 函数。
6. Return the `result` list containing all the combinations generated.  
    返回包含生成的所有组合 `result` 的列表。