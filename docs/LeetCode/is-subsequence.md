[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75)  
Given two strings `s` and `t`, return `true` _if_ `s` _is a **subsequence** of_ `t`_, or_ `false` _otherwise_.  
给定两个字符串 `s` 和 `t` ，返回 `true` if `s` 是 的 `t` 子序列，否则 `false` 。

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).  
字符串的子序列是通过删除某些（可以是无）字符而不干扰其余字符的相对位置而从原始字符串形成的新字符串。（即， `"ace"` 是 while `"aec"` 的 `"abcde"` 子序列不是）。

**Example 1: 示例 1：**

**Input:** s = "abc", t = "ahbgdc"
**Output:** true

**Example 2: 示例 2：**

**Input:** s = "axc", t = "ahbgdc"
**Output:** false

**Constraints: 约束：**

- `0 <= s.length <= 100`
- `0 <= t.length <= 104`
- `s` and `t` consist only of lowercase English letters.  
    `s` 并且 `t` 仅由小写英文字母组成。

**Follow up: 跟进：** Suppose there are lots of incoming `s`, say `s1, s2, ..., sk` where `k >= 109`, and you want to check one by one to see if `t` has its subsequence. In this scenario, how would you change your code?  
假设有很多传入 `s` 的，比如 `s1, s2, ..., sk` 说在哪里 `k >= 109` ，你想一个接一个地检查是否有 `t` 它的子序列。在这种情况下，您将如何更改代码？

```java
package org.leetcode;  
  
public class IsSubsequence {  
    public boolean isSubsequence(String s, String t) {  
        boolean isSubsequence = false;  
  
        if (s.length() > t.length()) {  
            return isSubsequence;  
        }  
        if (s.length() == 0) {  
            return true;  
        }  
        int sIndex = 0;  
        int tIndex = 0;  
  
        while (tIndex < t.length()) {  
            if (s.charAt(sIndex) == t.charAt(tIndex)) {  
                sIndex++;  
                if (sIndex == s.length()) {  
                    isSubsequence = true;  
                    break;                }  
            }  
            tIndex++;  
        }  
  
  
  
        return isSubsequence;  
    }  
  
    public static void main(String[] args) {  
        IsSubsequence obj = new IsSubsequence();  
        String s1 = "abc";  
        String t1 = "ahbgdc";  
        boolean expect1 = obj.isSubsequence(s1, t1);  
        boolean result1 = true;  
        if (expect1 == result1) {  
            System.out.println("test 1 Pass");  
        } else {  
            System.out.println("Fail expected: " + expect1 + " but got: " + result1);  
        }  
  
        String s2 = "axc";  
        String t2 = "ahbgdc";  
        boolean expect2 = obj.isSubsequence(s2, t2);  
        boolean result2 = false;  
        if (expect2 == result2) {  
            System.out.println("test 2 Pass");  
        } else {  
            System.out.println("Fail expected: " + expect2 + " but got: " + result2);  
        }  
    }  
}
```