[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75)  
Two strings are considered **close** if you can attain one from the other using the following operations:  
如果可以使用以下操作从另一个字符串获取两个字符串，则认为两个字符串接近：

- Operation 1: Swap any two **existing** characters.  
    操作 1：交换任意两个现有字符。
    - For example, `abcde -> aecdb` 例如 `abcde -> aecdb`
- Operation 2: Transform **every** occurrence of one **existing** character into another **existing** character, and do the same with the other character.  
    操作 2：将一个现有字符的每次出现转换为另一个现有字符，并对另一个字符执行相同的操作。
    - For example, `aacabb -> bbcbaa` (all `a`'s turn into `b`'s, and all `b`'s turn into `a`'s)  
        例如，（所有 都变成 's， `aacabb -> bbcbaa` 所有 `a` `b` 变成 `b` ' `a` s）

You can use the operations on either string as many times as necessary.  
您可以根据需要多次对任一字符串使用操作。

Given two strings, `word1` and `word2`, return `true` _if_ `word1` _and_ `word2` _are **close**, and_ `false` _otherwise._  
给定两个字符串，和 ，如果 和 `word2` `word2` 接近 `false` ， `word1` 则 `word1` 返回 `true` 。

**Example 1: 示例 1：**

**Input:** word1 = "abc", word2 = "bca"
**Output:** true
**Explanation:** You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

**Example 2: 示例 2：**

**Input:** word1 = "a", word2 = "aa"
**Output:** false
**Explanation:** It is impossible to attain word2 from word1, or vice versa, in any number of operations.

**Example 3: 例3：**

**Input:** word1 = "cabbba", word2 = "abbccc"
**Output:** true
**Explanation:** You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
`Apply Operation 2: "`caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

**Constraints: 约束：**

- `1 <= word1.length, word2.length <= 105`
- `word1` and `word2` contain only lowercase English letters.  
    `word1` 并且 `word2` 仅包含小写英文字母。

```java
package org.leetcode;  
  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
public class DetermineTwoStrClose {  
    public boolean closeStrings(String word1, String word2) {  
        //boolean status = false;  
        if (word1.length() != word2.length()) {  
            return false;  
        }  
  
  
        HashMap<Character, Integer> map = new HashMap<>();  
        HashMap<Character, Integer> map2 = new HashMap<>();  
  
        for(int i = 0 ; i < word1.length() ; i++){  
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0)+1);  
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);  
        }  
  
        for(int j= 0 ; j < word2.length() ;j++ ){  
            if(!map.containsKey(word2.charAt(j))){  
                return false;  
            }  
            if(!map2.containsKey(word1.charAt(j))){  
                return false;  
            }  
        }  
  
  
  
        ArrayList<Integer> list1 = new  ArrayList<>();  
        ArrayList<Integer> list2 = new ArrayList<>();  
  
        for(Map.Entry<Character,Integer> entry : map.entrySet()){  
            list1.add(entry.getValue());  
        }  
        for(Map.Entry<Character,Integer> entry : map2.entrySet()){  
            list2.add(entry.getValue());  
        }  
  
        Collections.sort(list1);  
        Collections.sort(list2);  
  
        return list1.equals(list2);  
  
    }  
  
    public static void main(String[] args) {  
        DetermineTwoStrClose obj = new DetermineTwoStrClose();  
        String word1_1 = "abc";  
        String word1_2 = "bca";  
        boolean result1 = obj.closeStrings(word1_1, word1_2);  
        boolean expected1 = true;  
        if (result1 == expected1) {  
            System.out.println("Test1 passed");  
        } else {  
            System.out.println("Test1 failed result is " + result1 + " but expected is " + expected1);  
        }  
  
        String word2_1 = "cabbba";  
        String word2_2 = "abbccc";  
        boolean result2 = obj.closeStrings(word2_1, word2_2);  
        boolean expected2 = true;  
        if (result2 == expected2) {  
            System.out.println("Test2 passed");  
        } else {  
            System.out.println("Test2 failed result is " + result2 + " but expected is " + expected2);  
        }  
    }  
}
```