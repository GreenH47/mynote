class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        result = []

        max_candies = max(candies)

        for i in candies:
            if i + extraCandies >= max_candies:
                result.append(True)
            else:
                result.append(False)
        return result

    def test(self):
        candies = [2, 3, 5, 1, 3]
        extraCandies = 3
        expected = [True, True, True, False, True]
        result = self.kidsWithCandies(candies, extraCandies)
        if result == expected:
            print("Passed")
        else:
            print("Failed result: ", result, " expected: ", expected)


if __name__ == "__main__":
    Solution().test()