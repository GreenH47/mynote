[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75)  
You are given a string `s`, which contains stars `*`.  
给你一个字符串 `s` ，其中包含星号 `*` 。

In one operation, you can:  
在一个操作中，您可以：

- Choose a star in `s`.  
    在 中 `s` 选择一个星号。
- Remove the closest **non-star** character to its **left**, as well as remove the star itself.  
    删除最靠近其左侧的非星号字符，以及删除星号本身。

Return _the string after **all** stars have been removed_.  
删除所有星号后返回字符串。

**Note: 注意：**

- The input will be generated such that the operation is always possible.  
    将生成输入，以便操作始终是可能的。
- It can be shown that the resulting string will always be unique.  
    可以证明，生成的字符串将始终是唯一的。

**Example 1: 示例 1：**

**Input:** s = "leet**cod*e"
**Output:** "lecoe"
**Explanation:** Performing the removals from left to right:
- The closest character to the 1st star is 't' in "lee**t****cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "le**e***cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "leco**d***e". s becomes "lecoe".
There are no more stars, so we return "lecoe".

**Example 2: 示例 2：**

**Input:** s = "erase*****"
**Output:** ""
**Explanation:** The entire string is removed, so we return an empty string.

**Constraints: 约束：**

- `1 <= s.length <= 105`
- `s` consists of lowercase English letters and stars `*`.  
    `s` 由小写英文字母和星星 `*` 组成。
- The operation above can be performed on `s`.  
    上述操作可以在 上 `s` 执行。  

```java
package org.leetcode;  
  
public class RemovingStarsFromString {  
    public static String removeStars(String s) {  
        String result = "";  
        for (int i = 0; i < s.length(); i++) {  
            if (s.charAt(i) != '*') {  
                result += s.charAt(i);  
            }  
            // if the current character is a star  
            // and the result string is not empty            // then remove the last character from the result string            else{  
                if(result.length() > 0){  
                    result = result.substring(0, result.length() - 1);  
                }  
            }  
        }  
  
        return result;  
    }  
  
  
    public static void main(String[] args) {  
        String s1 = "leet**cod*e";  
        String result1 = removeStars(s1);  
        String expected1 = "lecoe";  
        if (result1.equals(expected1)) {  
            System.out.println("Test 1 passed");  
        } else {  
            System.out.println("Test 1 failed expected: " + expected1 + " but got: " + result1);  
        }  
  
        String s2 = "erase*****";  
        String result2 = removeStars(s2);  
        String expected2 = "";  
        if (result2.equals(expected2)) {  
            System.out.println("Test 2 passed");  
        } else {  
            System.out.println("Test 2 failed expected: " + expected2 + " but got: " + result2);  
        }  
    }  
}
```