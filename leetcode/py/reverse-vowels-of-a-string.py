class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = "aeiouAEIOU"
        s = list(s)
        left = 0
        right = len(s) - 1

        while left < right:
            if s[left] in vowels and s[right] in vowels:
                s[left], s[right] = s[right], s[left]
                left += 1
                right -= 1
            elif s[left] not in vowels:
                left += 1
            elif s[right] not in vowels:
                right -= 1

        return "".join(s)

    def test(self):
        s = "hello"
        expected = "holle"
        actual = self.reverseVowels(s)
        if actual == expected:
            print("Test passed.")
        else:
            print("Test failed. %s != %s" % (actual, expected))

if __name__ == "__main__":
    Solution().test()
