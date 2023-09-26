class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        num_dict = {}  # Dictionary to store the visited numbers
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