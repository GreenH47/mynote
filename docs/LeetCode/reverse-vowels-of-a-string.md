[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75)  
Given a string `s`, reverse only all the vowels in the string and return it.  
给定一个字符串，只反转字符串 `s` 中的所有元音并返回它。

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.  
元音是 `'a'` 、、 `'e'` `'i'` 和 `'o'` `'u'` ，它们可以多次出现在小写和大写中。

**Example 1: 示例 1：**

**Input:** s = "hello"
**Output:** "holle"

**Example 2: 示例 2：**

**Input:** s = "leetcode"
**Output:** "leotcede"

**Constraints: 约束：**

- `1 <= s.length <= 3 * 105`
- `s` consist of **printable ASCII** characters.  
    `s` 由可打印的 ASCII 字符组成。

```python
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = "aeiouAEIOU"
        s = list(s)
        left = 0
        right = len(s) - 1

        while left < right:
            if s[left] in vowels and s[right] in vowels:
                s[left], s[right] = s[right], s[left]
                left += 1
                right -= 1
            elif s[left] not in vowels:
                left += 1
            elif s[right] not in vowels:
                right -= 1

        return "".join(s)

    def test(self):
        s = "hello"
        expected = "holle"
        actual = self.reverseVowels(s)
        if actual == expected:
            print("Test passed.")
        else:
            print("Test failed. %s != %s" % (actual, expected))

if __name__ == "__main__":
    Solution().test()

```