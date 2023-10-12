[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/jump-game-vii/)  
You are given a **0-indexed** binary string `s` and two integers `minJump` and `maxJump`. In the beginning, you are standing at index `0`, which is equal to `'0'`. You can move from index `i` to index `j` if the following conditions are fulfilled:  
您将获得一个 0 索引的二进制字符串 `s` 和两个整数 `minJump` 和 `maxJump` .一开始，您站在索引 `0` ，它等于 `'0'` 。如果满足以下条件，则可以从一个索引移动到另一个索引 `i` `j` ：

- `i + minJump <= j <= min(i + maxJump, s.length - 1)`, and  `i + minJump <= j <= min(i + maxJump, s.length - 1)` 和
- `s[j] == '0'`.

Return `true` _if you can reach index_ `s.length - 1` _in_ `s`_, or_ `false` _otherwise._  
如果可以达到 中的 `s` `false` 索引 `s.length - 1` ，则返回 `true` 。

**Example 1: 示例 1：**

**Input:** s = "011010", minJump = 2, maxJump = 3
**Output:** true
**Explanation:**
In the first step, move from index 0 to index 3. 
In the second step, move from index 3 to index 5.

# first version

```python
class Solution(object):  
    def canReach(self, s, minJump, maxJump):  
        """  
        :type s: str        :type minJump: int        :type maxJump: int        :rtype: bool  
        """        n = len(s)  
        index = []  
        reach_indicate = False  
  
        for i in range(n):  
            if s[i] == "0":  
                index.append(i)  
            else:  
                continue  
  
        dp = [False] * n  
        dp[0] = True  
  
        for i in range(1, n):  
            for j in range(i - minJump, i - maxJump - 1, -1):  
                if j >= 0 and s[j] == "0" and dp[j]:  
                    dp[i] = True  
                    break  
        return dp[-1]  
  
    def test(self):  
        s = "011010"  
        minJump = 2  
        maxJump = 3  
        assert self.canReach(s, minJump, maxJump) == True  
  
        s = "01101110"  
        minJump = 2  
        maxJump = 3  
        assert self.canReach(s, minJump, maxJump) == False  
  
        s = "01"  
        minJump = 1  
        maxJump = 1  
        assert self.canReach(s, minJump, maxJump) == False  
  
  
if __name__ == '__main__':  
    Solution().test()
```

it failed with the third test case

# second version
```python
class Solution(object):
    def canReach(self, s, minJump, maxJump):
        """
        :type s: str
        :type minJump: int
         maxJump: int
        :rtype: bool
        """
        dp = [c == '0' for c in s]
        pre = 0
        for i in range(1, len(s)):
            if i >= minJump:
                pre += dp[i - minJump]
            if i > maxJump:
                pre -= dp[i - maxJump - 1]
            dp[i] &= pre > 0
        return dp[-1]
```