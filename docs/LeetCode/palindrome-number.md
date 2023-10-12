[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/palindrome-number/)  
Given an integer `x`, return `true` _if_ `x` _is a_  
给定一个整数 `x` ，则 `x` 返回 `true` if 是

_**palindrome 回文**_

_, and  和_`false` _otherwise_.  `false` 否则。

**Example 1: 示例 1：**

**Input:** x = 121
**Output:** true
**Explanation:** 121 reads as 121 from left to right and from right to left.

**Example 2: 示例 2：**

**Input:** x = -121
**Output:** false
**Explanation:** From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

**Example 3: 例3：**

**Input:** x = 10
**Output:** false
**Explanation:** Reads 01 from right to left. Therefore it is not a palindrome.

**Constraints: 约束：**

- `-231 <= x <= 231 - 1`

**Follow up: 跟进：** Could you solve it without converting the integer to a string?  
你能在不将整数转换为字符串的情况下解决它吗？
```python
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x <0:
            return False

        temp = str(x)
        n = len(temp)
        for i in range(n):
            if temp[i] != temp[n - i - 1]:
                return False
        return True


    def test(self):
        x = 121
        assert self.isPalindrome(x) == True

        x = -121
        assert self.isPalindrome(x) == False

if __name__ == '__main__':
    Solution().test()
```