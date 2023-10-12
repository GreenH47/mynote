class Solution(object):
    def gcdOfStrings(self, str1, str2):
        """
        :type str1: str
        :type str2: str
        :rtype: str
        """

        # if str1 or str2 == "":
        #     print("One of the strings is empty.")
        #     return ""

        if len(str1) < len(str2):
            print("str1 is shorter than str2.")
            str1, str2 = str2, str1

        gcd_final = ""
        # find if the length has comman divisor
        divisor = 1
        for i in range(1, len(str2) + 1):
            if len(str1) % i == 0 and len(str2) % i == 0:
                divisor = i
                print("one potential divisor: %d" % divisor)
                gcd_str = self.gcd(str1, str2, divisor)
                if gcd_str != "":
                    gcd_final = gcd_str
                else:
                    print("divisor %d is not a common divisor." % divisor)
                    divisor = 1

        return gcd_final


        # if yes, then check if the string has common divisor
    def gcd(self, str1, str2, divisor):
        gcd_str = str1[:divisor]
        for i in range(0, len(str1), divisor):
            if str1[i:i + divisor] != gcd_str:
                return ""
        for i in range(0, len(str2), divisor):
            if str2[i:i + divisor] != gcd_str:
                return ""
        return gcd_str



    def test(self):
        str1 = "ABABABAB"
        str2 = "ABAB"
        expected = "ABAB"
        result = self.gcdOfStrings(str1, str2)
        if result != expected:
            print("Test failed. %s != %s" % (result, expected))
        if result == expected:
            print("Test passed. common divisor is %s" % result)

if __name__ == "__main__":
    Solution().test()