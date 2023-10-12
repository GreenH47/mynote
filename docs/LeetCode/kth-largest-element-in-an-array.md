[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75)  
Given an integer array `nums` and an integer `k`, return _the_ `kth` _largest element in the array_.  
给定一个整数数组和一个整数 `k` ，返回数组 `nums` 中 `kth` 最大的元素。

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.  
请注意，它是排序顺序中 `kth` 最大的元素，而不是 `kth` 非重复元素。

Can you solve it without sorting?  
你能在不排序的情况下解决它吗？

**Example 1: 示例 1：**

**Input:** nums = [3,2,1,5,6,4], k = 2
**Output:** 5

**Example 2: 示例 2：**

**Input:** nums = [3,2,3,1,2,4,5,5,6], k = 4
**Output:** 4

**Constraints: 约束：**

- `1 <= k <= nums.length <= 105`
- `-104 <= nums[i] <= 104`

```java
package org.leetcode;  
import java.util.*;  
public class FindKthLargest {  
    public int findKthLargest(int[] nums, int k) {  
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  
        for (int num : nums) {  
            minHeap.add(num);  
            if (minHeap.size() > k) {  
                // remove the smallest element  
                minHeap.remove();  
            }  
        }  
        // the kth largest element is at the top of the heap  
        return minHeap.peek();  
  
    }  
  
    public static void main(String[] args){  
        FindKthLargest obj = new FindKthLargest();  
        int[] nums1 = {3,2,1,5,6,4};  
        int k1 = 2;  
        int expect1 = 5;  
        int result1 = obj.findKthLargest(nums1, k1);  
        if (expect1 == result1) {  
            System.out.println("Pass test 1");  
        } else {  
            System.out.println("Fail test 1, expect: " + expect1 + " but got: " + result1);  
        }  
  
        int[] nums2 = {3,2,3,1,2,4,5,5,6};  
        int k2 = 4;  
        int expect2 = 4;  
        int result2 = obj.findKthLargest(nums2, k2);  
        if (expect2 == result2) {  
            System.out.println("Pass test 2");  
        } else {  
            System.out.println("Fail test 2, expect: " + expect2 + " but got: " + result2);  
        }  
    }  
}
```