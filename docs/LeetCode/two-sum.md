[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/two-sum/)  
Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.  
给定一个整数数组 `target` 和一个整数 `nums` ，返回这两个数字的索引，使得它们加起来为 `target` 。

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.  
您可以假设每个输入只有一个解决方案，并且您可能不会两次使用同一个元素。

You can return the answer in any order.  
您可以按任意顺序返回答案。

**Example 1: 示例 1：**

**Input:** nums = [2,7,11,15], target = 9
**Output:** [0,1]
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

**Example 2: 示例 2：**

**Input:** nums = [3,2,4], target = 6
**Output:** [1,2]

**Example 3: 例3：**

**Input:** nums = [3,3], target = 6
**Output:** [0,1]

**Constraints: 约束：**

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- **Only one valid answer exists.  
    只有一个有效的答案存在。**

**Follow-up:  随访：**Can you come up with an algorithm that is less than `O(n2)` time complexity?  
你能想出一个小于 `O(n2)` 时间复杂度的算法吗？

```run-python
class Solution(object):  
    def twoSum(self, nums, target):  
        """  
        :type nums: List[int]        :type target: int        :rtype: List[int]  
        """        num_dict = {}  # Dictionary to store the visited numbers  
        for i, num in enumerate(nums):  
            complement = target - num  
            if complement in num_dict:  
                return [num_dict[complement], i]  
            num_dict[num] = i  
  
        return []  # No two numbers found that add up to the target  
  
    def twoSum_test(self):  
        nums = [2, 7, 11, 15]  
        target = 9  
        output = [0, 1]  
        assert self.twoSum(nums, target) == output  
        print("Test 1: Passed")  
  
  
if __name__ == '__main__':  
    sol = Solution()  
    sol.twoSum_test()
```

1. Create an empty dictionary to store the visited numbers along with their indices.  
    创建一个空字典来存储访问的号码及其索引。
2. Iterate through the array `nums` using the `enumerate` function.  
    使用该 `enumerate` 函数循环访问数组 `nums` 。
3. For each number `num`, calculate the complement by subtracting `num` from the target.  
    对于每个数 `num` ，通过 `num` 从目标中减去来计算补码。
4. Check if the complement exists in the dictionary `num_dict`.  
    检查字典中是否存在补码 `num_dict` 。
5. If the complement exists, return the indices of `num` and the complement.  
    如果补码存在，则返回 和补码的 `num` 索引。
6. If the complement doesn't exist, add `num` to the dictionary with its index as the value.  
    如果补码不存在，则将其 `num` 索引作为值添加到字典中。
7. If no two numbers are found that add up to the target, return an empty list.  
    如果未找到两个加起来与目标相加的数字，则返回一个空列表。
    
[Python Tutor code visualizer: Visualize code in Python, JavaScript, C, C++, and Java](https://pythontutor.com/render.html#code=class%20Solution%28object%29%3A%0A%20%20%20%20def%20twoSum%28self,%20nums,%20target%29%3A%0A%20%20%20%20%20%20%20%20%22%22%22%0A%20%20%20%20%20%20%20%20%3Atype%20nums%3A%20List%5Bint%5D%0A%20%20%20%20%20%20%20%20%3Atype%20target%3A%20int%0A%20%20%20%20%20%20%20%20%3Artype%3A%20List%5Bint%5D%0A%20%20%20%20%20%20%20%20%22%22%22%0A%20%20%20%20%20%20%20%20num_dict%20%3D%20%7B%7D%20%20%23%20Dictionary%20to%20store%20the%20visited%20numbers%0A%20%20%20%20%20%20%20%20for%20i,%20num%20in%20enumerate%28nums%29%3A%0A%20%20%20%20%20%20%20%20%20%20%20%20complement%20%3D%20target%20-%20num%0A%20%20%20%20%20%20%20%20%20%20%20%20if%20complement%20in%20num_dict%3A%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20return%20%5Bnum_dict%5Bcomplement%5D,%20i%5D%0A%20%20%20%20%20%20%20%20%20%20%20%20num_dict%5Bnum%5D%20%3D%20i%0A%0A%20%20%20%20%20%20%20%20return%20%5B%5D%20%20%23%20No%20two%20numbers%20found%20that%20add%20up%20to%20the%20target%0A%0A%20%20%20%20def%20twoSum_test%28self%29%3A%0A%20%20%20%20%20%20%20%20nums%20%3D%20%5B2,%207,%2011,%2015%5D%0A%20%20%20%20%20%20%20%20target%20%3D%209%0A%20%20%20%20%20%20%20%20output%20%3D%20%5B0,%201%5D%0A%20%20%20%20%20%20%20%20assert%20self.twoSum%28nums,%20target%29%20%3D%3D%20output%0A%20%20%20%20%20%20%20%20print%28%22Test%201%3A%20Passed%22%29%0A%0A%0Aif%20__name__%20%3D%3D%20'__main__'%3A%0A%20%20%20%20sol%20%3D%20Solution%28%29%0A%20%20%20%20sol.twoSum_test%28%29&cumulative=false&curInstr=13&heapPrimitives=nevernest&mode=display&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false)  
