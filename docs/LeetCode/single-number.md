Given a **non-empty** array of integers `nums`, every element appears _twice_ except for one. Find that single one.  
给定一个非空的整数数组，每个元素出现两次 `nums` ，除了一个。找到那个。

You must implement a solution with a linear runtime complexity and use only constant extra space.  
您必须实现具有线性运行时复杂性的解决方案，并且仅使用常量的额外空间。

**Example 1: 示例 1：**

**Input:** nums = [2,2,1]
**Output:** 1

**Example 2: 示例 2：**

**Input:** nums = [4,1,2,1,2]
**Output:** 4

**Example 3: 例3：**

**Input:** nums = [1]
**Output:** 1

**Constraints: 约束：**

- `1 <= nums.length <= 3 * 104`
- `-3 * 104 <= nums[i] <= 3 * 104`
- Each element in the array appears twice except for one element which appears only once.  
    数组中的每个元素出现两次，但一个元素只出现一次。

```java
package org.leetcode;  
  
public class SingleNumber {  
    public int singleNumber(int[] nums) {  
        int result = 0;  
        for (int i = 0 ; i < nums.length ; i++) {  
            result ^= nums[i];  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        SingleNumber obj = new SingleNumber();  
        int[] nums1 = {2,2,1};  
        int result1 = obj.singleNumber(nums1);  
        int expected1 = 1;  
        if (result1 == expected1) {  
            System.out.println("Test1 passed");  
        } else {  
            System.out.println("Test1 failed");  
        }  
  
        int[] nums2 = {4,1,2,1,2};  
        int result2 = obj.singleNumber(nums2);  
        int expected2 = 4;  
        if (result2 == expected2) {  
            System.out.println("Test2 passed");  
        } else {  
            System.out.println("Test2 failed");  
        }  
    }  
}
```