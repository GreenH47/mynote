[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/zigzag-conversion/)  
pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)  
字符串 `"PAYPALISHIRING"` 以锯齿形模式写在给定数量的行上，如下所示：（您可能希望以固定字体显示此模式以获得更好的可读性）

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: `"PAHNAPLSIIGYIR"`  
然后逐行阅读： `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:  
编写将接受字符串的代码，并在给定行数的情况下进行此转换：

string convert(string s, int numRows);

**Example 1: 示例 1：**

**Input:** s = "PAYPALISHIRING", numRows = 3
**Output:** "PAHNAPLSIIGYIR"

**Example 2: 示例 2：**

**Input:** s = "PAYPALISHIRING", numRows = 4
**Output:** "PINALSIGYAHRPI"
**Explanation:**
P     I    N
A   L S  I G
Y A   H R
P     I

**Example 3: 例3：**

**Input:** s = "A", numRows = 1
**Output:** "A"

**Constraints: 约束：**

- `1 <= s.length <= 1000`
- `s` consists of English letters (lower-case and upper-case), `','` and `'.'`.  
    `s` 由英文字母（小写和大写） `','` 和 `'.'` .
- `1 <= numRows <= 1000`

```java
package org.leetcode;  
  
public class ZigzagConversion {  
    public String convert(String s, int numRows) {  
  
        int length = s.length();  
        if (numRows == 1 || length <= numRows) {  
            return s;  
        }  
  
        StringBuilder[] rows = new StringBuilder[numRows];  
        for (int i = 0; i < numRows; i++) {  
            rows[i] = new StringBuilder();  
        }  
  
        int currentRow = 0;  
        boolean goingDown = false;  
  
        for (char c : s.toCharArray()) {  
            rows[currentRow].append(c);  
  
            if (currentRow == 0 || currentRow == numRows - 1) {  
                goingDown = !goingDown;  
            }  
  
            currentRow += goingDown ? 1 : -1;  
        }  
  
        StringBuilder result = new StringBuilder();  
        for (StringBuilder row : rows) {  
            result.append(row);  
        }  
  
        return result.toString();  
    }  
  
    public String convertMatrix(String s, int numRows) {  
  
        int length = s.length();  
        if (numRows == 1 || length <= numRows) {  
            return s;  
        }  
        char[][] result = new char[numRows][s.length()];  
  
        int currentRow = 0;  
        boolean goingDown = false;  
        int index = 0;  
  
        for (char c : s.toCharArray()) {  
            result[currentRow][index] = c;  
  
            if (currentRow == 0 || currentRow == numRows - 1) {  
                goingDown = !goingDown;  
            }  
  
            currentRow += goingDown ? 1 : -1;  
            index++;  
        }  
  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < numRows; i++) {  
            for (int j = 0; j < index; j++) {  
                if (result[i][j] != '\0') {  
                    sb.append(result[i][j]);  
                }  
            }  
        }  
  
        return sb.toString();  
    }  
  
    public static void main(String[] args) {  
        ZigzagConversion zigzagConversion = new ZigzagConversion();  
        String s1 = "PAYPALISHIRING";  
        int numRows1 = 3;  
        String result1 = zigzagConversion.convert(s1, numRows1);  
        String expected1 = "PAHNAPLSIIGYIR";  
        if (!result1.equals(expected1)) {  
            System.out.println("Test failed for " + s1 + " with result " + result1);  
        }  
        else {  
            System.out.println("Test passed for " + s1);  
        }  
  
        String s2 = "PAYPALISHIRING";  
        int numRows2 = 4;  
        String result2 = zigzagConversion.convertMatrix(s2, numRows2);  
        String expected2 = "PINALSIGYAHRPI";  
        if (!result2.equals(expected2)) {  
            System.out.println("Test failed for " + s2 + " with result " + result2);  
        }  
        else {  
            System.out.println("Test passed for " + s2);  
        }  
  
  
    }  
}
```