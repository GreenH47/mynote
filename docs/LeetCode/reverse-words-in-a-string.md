[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75)  
Given an input string `s`, reverse the order of the **words**.  
给定一个输入字符串 `s` ，颠倒单词的顺序。

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.  
单词定义为非空格字符序列。中的 `s` 字词将至少用一个空格分隔。

Return _a string of the words in reverse order concatenated by a single space._  
以相反的顺序返回由单个空格连接的单词字符串。

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.  
请注意，可能包含 `s` 前导或尾随空格或两个单词之间的多个空格。返回的字符串应该只有一个空格来分隔单词。不要包含任何多余的空格。

**Example 1: 示例 1：**

**Input:** s = "the sky is blue"
**Output:** "blue is sky the"

**Example 2: 示例 2：**

**Input:** s = "  hello world  "
**Output:** "world hello"
**Explanation:** Your reversed string should not contain leading or trailing spaces.

**Example 3: 例3：**

**Input:** s = "a good   example"
**Output:** "example good a"
**Explanation:** You need to reduce multiple spaces between two words to a single space in the reversed string.

**Constraints: 约束：**

- `1 <= s.length <= 104`
- `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.  
    `s` 包含英文字母（大写和小写）、数字和空格 `' '` 。
- There is **at least one** word in `s`.  
    中 `s` 至少有一个单词。

**Follow-up:** If the string data type is mutable in your language, can you solve it **in-place** with `O(1)` extra space?  
跟进：如果字符串数据类型在您的语言中是可变的，你能用额外的空间就 `O(1)` 地解决它吗？

```java
package org.leetcode;  
  
public class ReverseWordsInString {  
    public String reverseWords(String s) {  
        String[] words = s.split("\\s+");  
  
  
        String[] reversedWords = new String[words.length];  
        for (int i = 0; i < words.length; i++) {  
            reversedWords[i] = words[words.length - 1 - i];  
        }  
  
        String reversedSentence = String.join(" ", reversedWords);  
        // delete the last space  
        return reversedSentence.trim();  
    }  
  
    public static void main(String[] args) {  
        String sentence1 = "The dog is the best";  
        String reversedSentence1 = new ReverseWordsInString().reverseWords(sentence1);  
        System.out.println("Reversed sentence1: " + reversedSentence1); // Expected output: "best the is dog The"  
  
        String sentence2 = "  hello world  ";  
        String reversedSentence2 = new ReverseWordsInString().reverseWords(sentence2);  
        System.out.println("Reversed sentence2: " + reversedSentence2); // Expected output: "full so am I thanksgiving, Happy"  
  
  
        String sentence3 = "a good   example";  
        String reversedSentence3 = new ReverseWordsInString().reverseWords(sentence3);  
        System.out.println("Reversed sentence3: " + reversedSentence3); // Expected output: "example good a"  
    }  
}
```