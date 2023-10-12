class Solution(object):
    def canReach(self, s, minJump, maxJump):
        """
        :type s: str
        :type minJump: int
        :type maxJump: int
        :rtype: bool
        """
        n = len(s)
        index = []
        reach_indicate = True

        # Check for early exit conditions
        if s[0] != '0' or s[n - 1] != '0':
            return False

        for i in range(n):
            if s[i] == "0":
                index.append(i)
            else:
                continue

        for i in range(len(index)):
            for j in range(i + 1, len(index)):
                if (index[j] - index[i] < minJump) or (index[j] > min(index[i] + maxJump, n - 1)):
                    return False

        return reach_indicate

    def test(self):
        s = "011010"
        minJump = 2
        maxJump = 3
        assert self.canReach(s, minJump, maxJump) == True

        s = "01101110"
        minJump = 2
        maxJump = 3
        assert self.canReach(s, minJump, maxJump) == False

        s = "01"
        minJump = 1
        maxJump = 1
        assert self.canReach(s, minJump, maxJump) == False


if __name__ == '__main__':
    Solution().test()
