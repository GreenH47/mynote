[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75)  
There are `n` kids with candies. You are given an integer array `candies`, where each `candies[i]` represents the number of candies the `ith` kid has, and an integer `extraCandies`, denoting the number of extra candies that you have.  
有 `n` 孩子拿糖果。给你一个整数数组，其中每个 `candies[i]` 代表 `ith` `candies` 孩子拥有的糖果数量，以及一个整数 `extraCandies` ，表示您拥有的额外糖果数量。

Return _a boolean array_ `result` _of length_ `n`_, where_ `result[i]` _is_ `true` _if, after giving the_ `ith` _kid all the_ `extraCandies`_, they will have the **greatest** number of candies among all the kids__, or_ `false` _otherwise_.  
返回一个长度的布尔数组 `result` ，其中 `result[i]` is 如果 `true` ，在给孩子所有之后，他们将拥有所有 `ith` 孩子中最多的糖果 `extraCandies` ，否则 `false` 。 `n`

Note that **multiple** kids can have the **greatest** number of candies.  
请注意，多个孩子可以拥有最多的糖果。

**Example 1: 示例 1：**

**Input:** candies = [2,3,5,1,3], extraCandies = 3
**Output:** [true,true,true,false,true] 
**Explanation:** If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.

**Example 2: 示例 2：**

**Input:** candies = [4,2,1,1,2], extraCandies = 1
**Output:** [true,false,false,false,false] 
**Explanation:** There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.

**Example 3: 例3：**

**Input:** candies = [12,1,12], extraCandies = 10
**Output:** [true,false,true]

**Constraints: 约束：**

- `n == candies.length`
- `2 <= n <= 100`
- `1 <= candies[i] <= 100`
- `1 <= extraCandies <= 50`

```python
class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        result = []

        max_candies = max(candies)

        for i in candies:
            if i + extraCandies >= max_candies:
                result.append(True)
            else:
                result.append(False)
        return result

    def test(self):
        candies = [2, 3, 5, 1, 3]
        extraCandies = 3
        expected = [True, True, True, False, True]
        result = self.kidsWithCandies(candies, extraCandies)
        if result == expected:
            print("Passed")
        else:
            print("Failed result: ", result, " expected: ", expected)


if __name__ == "__main__":
    Solution().test()
```