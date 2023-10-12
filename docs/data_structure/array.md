## Rotate Array 
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

**Example 1:**

**Input:** nums = [1,2,3,4,5,6,7], k = 3
**Output:** [5,6,7,1,2,3,4]
**Explanation:**
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

**Example 2:**

**Input:** nums = [-1,-100,3,99], k = 2
**Output:** [3,99,-1,-100]
**Explanation:** 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```run-java
public class Solution {
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        // Handle the case where k is greater than the array length
        k = k % n;

        // Rotate the array
        for (int i = 0; i < n; i++) {
            // Calculate the new index for each element
            int newIndex = (i + k) % n;
            result[newIndex] = nums[i];
        }

        return result;
    }
    
    
    public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;

    Solution solution = new Solution();
    int[] result = solution.rotate(nums, k);

    // Output the resulting array
    for (int num : result) {
        System.out.print(num + " ");
    }
    // Output: 5 6 7 1 2 3 4
}

}

```
We create a new array result of the same size as nums to store the rotated elements.
我们创建一个与存储旋转元素相同 nums 大小的新数组 result 。
We iterate through the original array nums and calculate the new index for each element using the formula (i + k) % n, where i is the current index and n is the length of the array.
我们遍历原始数组并使用公式 (i + k) % n 计算每个元素的新索引，其中 i 是当前索引， n 是数组 nums 的长度。
We assign each element to its corresponding new index in the result array.
我们将每个元素分配给 result 数组中相应的新索引。