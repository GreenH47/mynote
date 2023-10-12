[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75)  
You are given an integer array `nums` consisting of `n` elements, and an integer `k`.  
您将获得一个由 `n` 元素组成的整数数组 `nums` 和一个整数 `k` .

Find a contiguous subarray whose **length is equal to** `k` that has the maximum average value and return _this value_. Any answer with a calculation error less than `10-5` will be accepted.  
找到一个长度等于具有最大平均值 `k` 的连续子数组，并返回此值。任何计算误差小于 `10-5` 的答案都将被接受。

**Example 1: 示例 1：**

**Input:** nums = [1,12,-5,-6,50,3], k = 4
**Output:** 12.75000
**Explanation:** Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

**Example 2: 示例 2：**

**Input:** nums = [5], k = 1
**Output:** 5.00000

**Constraints: 约束：**

- `n == nums.length`
- `1 <= k <= n <= 105`
- `-104 <= nums[i] <= 104`

```java
package org.leetcode;  
  
public class MaximumAverageSubarrayI {  
    public double findMaxAverage(int[] nums, int k) {  
  
        int sum = 0;  
        for(int i = 0; i < k; i++) {  
            sum = sum + nums[i];  
        }  
  
        int i = k;  
        int j = 0;  
        double result = sum/k;  
        while(i < nums.length) {  
            sum += nums[i];  
            sum -= nums[j];  
            result = Math.max(result, sum/k);  
            i++;  
            j++;  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();  
        int[] nums1 = {1,12,-5,-6,50,3};  
        int k1 = 4;  
        double result1 = maximumAverageSubarrayI.findMaxAverage(nums1, k1);  
        double expected1 = 12.75;  
        if(result1 == expected1) {  
            System.out.println("Test 1 passed");  
        } else {  
            System.out.println("Test 1 failed expected: " + expected1 + " actual: " + result1);  
        }  
  
        int[] nums2 = {5};  
        int k2 = 1;  
        double result2 = maximumAverageSubarrayI.findMaxAverage(nums2, k2);  
        double expected2 = 5;  
        if(result2 == expected2) {  
            System.out.println("Test 2 passed");  
        } else {  
            System.out.println("Test 2 failed expected: " + expected2 + " actual: " + result2);  
        }  
    }  
}
```