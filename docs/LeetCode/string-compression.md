[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75)  
Given an array of characters `chars`, compress it using the following algorithm:  
给定一个字符 `chars` 数组，使用以下算法对其进行压缩：

Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:  
以空字符串 `s` 开头。对于 中的 `chars` 每组连续重复字符：

- If the group's length is `1`, append the character to `s`.  
    如果组的长度为 `1` ，则将字符追加到 `s` 。
- Otherwise, append the character followed by the group's length.  
    否则，附加字符后跟组的长度。

The compressed string `s` **should not be returned separately**, but instead, be stored **in the input character array `chars`**. Note that group lengths that are `10` or longer will be split into multiple characters in `chars`.  
压缩字符串 `s` 不应单独返回，而应存储在输入字符数组 `chars` 中。请注意，组长度为 或更长的组长度将在 中 `chars` 拆分为 `10` 多个字符。

After you are done **modifying the input array,** return _the new length of the array_.  
修改完输入数组后，返回数组的新长度。

You must write an algorithm that uses only constant extra space.  
您必须编写仅使用常量额外空间的算法。

**Example 1: 示例 1：**

**Input:** chars = ["a","a","b","b","c","c","c"]
**Output:** Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
**Explanation:** The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

**Example 2: 示例 2：**

**Input:** chars = ["a"]
**Output:** Return 1, and the first character of the input array should be: ["a"]
**Explanation:** The only group is "a", which remains uncompressed since it's a single character.

**Example 3: 例3：**

**Input:** chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
**Output:** Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
**Explanation:** The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

**Constraints: 约束：**

- `1 <= chars.length <= 2000`
- `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.  
    `chars[i]` 是小写英文字母、大写英文字母、数字或符号。

