class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x <0:
            return False

        temp = str(x)
        n = len(temp)
        for i in range(n):
            if temp[i] != temp[n - i - 1]:
                return False
        return True


    def test(self):
        x = 121
        assert self.isPalindrome(x) == True

        x = -121
        assert self.isPalindrome(x) == False

if __name__ == '__main__':
    Solution().test()