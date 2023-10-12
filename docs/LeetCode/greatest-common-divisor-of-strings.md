[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75)  
For two strings `s` and `t`, we say "`t` divides `s`" if and only if `s = t + ... + t` (i.e., `t` is concatenated with itself one or more times).  
对于两个字符串 `s` 和 `t` ，我们说“ `t` 除法 `s` ”当且仅当 `s = t + ... + t` （即与 `t` 自身连接一次或多次）。

Given two strings `str1` and `str2`, return _the largest string_ `x` _such that_ `x` _divides both_ `str1` _and_ `str2`.  
给定两个字符串 和 ，返回最大的字符串 `str1` `x` ，以便 `x` 将两者 `str1` 除以 和 `str2` `str2` 。

**Example 1: 示例 1：**

**Input:** str1 = "ABCABC", str2 = "ABC"
**Output:** "ABC"

**Example 2: 示例 2：**

**Input:** str1 = "ABABAB", str2 = "ABAB"
**Output:** "AB"

**Example 3: 例3：**

**Input:** str1 = "LEET", str2 = "CODE"
**Output:** ""

**Constraints: 约束：**

- `1 <= str1.length, str2.length <= 1000`
- `str1` and `str2` consist of English uppercase letters.  
    `str1` 由 `str2` 英文大写字母组成。


```python
class Solution(object):  
    def gcdOfStrings(self, str1, str2):  
        """  
        :type str1: str        :type str2: str        :rtype: str  
        """  
        # if str1 or str2 == "":  
        #     print("One of the strings is empty.")        #     return ""  
        if len(str1) < len(str2):  
            print("str1 is shorter than str2.")  
            str1, str2 = str2, str1  
  
        gcd_final = ""  
        # find if the length has comman divisor  
        divisor = 1  
        for i in range(1, len(str2) + 1):  
            if len(str1) % i == 0 and len(str2) % i == 0:  
                divisor = i  
                print("one potential divisor: %d" % divisor)  
                gcd_str = self.gcd(str1, str2, divisor)  
                if gcd_str != "":  
                    gcd_final = gcd_str  
                else:  
                    print("divisor %d is not a common divisor." % divisor)  
                    divisor = 1  
  
        return gcd_final  
  
  
        # if yes, then check if the string has common divisor  
    def gcd(self, str1, str2, divisor):  
        gcd_str = str1[:divisor]  
        for i in range(0, len(str1), divisor):  
            if str1[i:i + divisor] != gcd_str:  
                return ""  
        for i in range(0, len(str2), divisor):  
            if str2[i:i + divisor] != gcd_str:  
                return ""  
        return gcd_str  
  
  
  
    def test(self):  
        str1 = "ABABABAB"  
        str2 = "ABAB"  
        expected = "ABAB"  
        result = self.gcdOfStrings(str1, str2)  
        if result != expected:  
            print("Test failed. %s != %s" % (result, expected))  
        if result == expected:  
            print("Test passed. common divisor is %s" % result)  
  
if __name__ == "__main__":  
    Solution().test()
```