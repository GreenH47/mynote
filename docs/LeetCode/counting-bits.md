Given an integer `n`, return _an array_ `ans` _of length_ `n + 1` _such that for each_ `i` (`0 <= i <= n`)_,_ `ans[i]` _is the **number of**_ `1`_**'s** in the binary representation of_ `i`.  
给定一个整数，返回一个长度的数组 `n` ，使得对于每个 `i` （ `0 <= i <= n` ）， `ans[i]` 是 的 `i` 二进制表示中的 `1` 的 `ans` 个 `n + 1` 数。

**Example 1: 示例 1：**

**Input:** n = 2
**Output:** [0,1,1]
**Explanation:**
0 --> 0
1 --> 1
2 --> 10

**Example 2: 示例 2：**

**Input:** n = 5
**Output:** [0,1,1,2,1,2]
**Explanation:**
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

**Constraints: 约束：**

- `0 <= n <= 105`

**Follow up: 跟进：**

- It is very easy to come up with a solution with a runtime of `O(n log n)`. Can you do it in linear time `O(n)` and possibly in a single pass?  
    很容易提出运行时为 . `O(n log n)` 你能在线性时间内 `O(n)` 完成，也可能在一次通过中完成吗？
- Can you do it without using any built-in function (i.e., like `__builtin_popcount` in C++)?  
    您可以在不使用任何内置函数的情况下做到这一点（即，就像在C++中一样 `__builtin_popcount` ）吗？

```java
package org.leetcode;  
  
public class CountBits {  
    public int[] countBits(int n) {  
        int[] result = new int[n+1];  
        for(int i = 1 ; i <= n ; i++){  
            result[i] = result[i/2] + i%2;  
        }  
        return result;  
    }  
    public boolean compare(int[] result, int[] expected) {  
        if (result.length != expected.length) {  
            return false;  
        } else {  
            boolean status = true;  
            for (int i = 0; i < result.length; i++) {  
                if (result[i] != expected[i]) {  
                    status = false;  
                    break;                }  
            }  
            return status;  
        }  
    }  
  
    public static void main(String[] args) {  
        CountBits obj = new CountBits();  
        int input1 = 2;  
        int[] result1 = obj.countBits(input1);  
        int[] expected1 = {0, 1, 1};  
        // compare result1 and expected1 value  
        boolean status1 = obj.compare(result1, expected1);  
        if (status1) {  
            System.out.println("Test1 passed");  
        } else {  
            System.out.println("Test1 failed");  
        }  
  
        int input2 = 5;  
        int[] result2 = obj.countBits(input2);  
        int[] expected2 = {0, 1, 1, 2, 1, 2};  
        // compare result2 and expected2 value  
        boolean status2 = obj.compare(result2, expected2);  
        if (status2) {  
            System.out.println("Test2 passed");  
        } else {  
            System.out.println("Test2 failed");  
        }  
    }  
}
```