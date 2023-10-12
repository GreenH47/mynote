class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        mergeString = ""
        i=0
        j=0
        while i < len(word1) and j < len(word2):
            mergeString += word1[i]
            mergeString += word2[j]
            i += 1
            j += 1

        if i < len(word1):
            mergeString += word1[i:]
        if j < len(word2):
            mergeString += word2[j:]
        return mergeString

    def test(self):
        word1 = "abc"
        word2 = "pqr"
        expected = "apbqcr"
        actual = self.mergeAlternately(word1, word2)
        if actual == expected:
            print("Test passed.")
        else:
            print("Test failed. %s != %s" % (actual, expected))



if __name__ == "__main__":
    Solution().test()