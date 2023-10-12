[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75)  
You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.  
您将获得两个字符串 `word1` 和 `word2` .通过交替添加字母（从 开始 `word1` ）来合并字符串。如果一个字符串比另一个字符串长，请将其他字母附加到合并字符串的末尾。

Return _the merged string._  
返回合并的字符串。

**Example 1: 示例 1：**

**Input:** word1 = "abc", word2 = "pqr"
**Output:** "apbqcr"
**Explanation:** The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

**Example 2: 示例 2：**

**Input:** word1 = "ab", word2 = "pqrs"
**Output:** "apbqrs"
**Explanation:** Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

**Example 3: 例3：**

**Input:** word1 = "abcd", word2 = "pq"
**Output:** "apbqcd"
**Explanation:** Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d

**Constraints: 约束：**

- `1 <= word1.length, word2.length <= 100`
- `word1` and `word2` consist of lowercase English letters.  
    `word1` 由 `word2` 小写英文字母组成。

```python
class Solution(object):  
    def mergeAlternately(self, word1, word2):  
        """  
        :type word1: str        :type word2: str        :rtype: str  
        """        mergeString = ""  
        i=0  
        j=0  
        while i < len(word1) and j < len(word2):  
            mergeString += word1[i]  
            mergeString += word2[j]  
            i += 1  
            j += 1  
  
        if i < len(word1):  
            mergeString += word1[i:]  
        if j < len(word2):  
            mergeString += word2[j:]  
        return mergeString  
  
    def test(self):  
        word1 = "abc"  
        word2 = "pqr"  
        expected = "apbqcr"  
        actual = self.mergeAlternately(word1, word2)  
        if actual == expected:  
            print("Test passed.")  
        else:  
            print("Test failed. %s != %s" % (actual, expected))  
  
  
  
if __name__ == "__main__":  
    Solution().test()
```

