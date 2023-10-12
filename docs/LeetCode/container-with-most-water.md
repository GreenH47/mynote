[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75)  
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.  
您将获得一个长度 `n` 的整数数组 `height` 。绘制了 `n` 垂直线，使得 `ith` 线的两个端点是 `(i, 0)` 和 `(i, height[i])` 。

Find two lines that together with the x-axis form a container, such that the container contains the most water.  
找到两条与 x 轴一起形成容器的线，这样容器包含的水最多。

Return _the maximum amount of water a container can store_.  
返回容器可以储存的最大水量。

**Notice** that you may not slant the container.  
请注意，您不能倾斜容器。

**Example 1: 示例 1：**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

**Input:** height = [1,8,6,2,5,4,8,3,7]
**Output:** 49
**Explanation:** The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

**Example 2: 示例 2：**

**Input:** height = [1,1]
**Output:** 1

**Constraints: 约束：**

- `n == height.length`
- `2 <= n <= 105`
- `0 <= height[i] <= 104`
```java
package org.leetcode;  
  
public class ContainerWithMostWater {  
    public int maxArea(int[] height) {  
        int area = 0;  
        int left = 0;  
        int right = height.length - 1;  
        while(left < right) {  
            int currentHeight = Math.min(height[left], height[right]);  
            int currentWidth = right - left;  
            int currentArea = currentHeight * currentWidth;  
            if(currentArea > area) {  
                area = currentArea;  
            }  
            if(height[left] < height[right]) {  
                left++;  
            } else {  
                right--;  
            }  
        }  
  
        return area;  
    }  
  
    public static void main(String[] args) {  
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();  
        int[] height1 = {1,8,6,2,5,4,8,3,7};  
        int result1 = containerWithMostWater.maxArea(height1);  
        int expected1 = 49;  
        if(result1 == expected1) {  
            System.out.println("Test 1 passed");  
        } else {  
            System.out.println("Test 1 failed expected: " + expected1 + " actual: " + result1);  
        }  
    }  
}
```