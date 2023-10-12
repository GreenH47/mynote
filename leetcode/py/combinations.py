class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        results = []  # List to store the combinations
        current = []  # List to store the current combination

        def track(start,current):
            if len(current) == k:
                results.append(current[:])
                return

            for i in range(start, n + 1):
                current.append(i)
                track(i + 1, current)
                current.pop()

        track(1, current)

        return results

    def combine_test(self):
        n = 4
        k = 2
        output = [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        assert self.combine(n, k) == output
        print("Test 1: Passed")

if __name__ == '__main__':
    sol = Solution()
    sol.combine_test()
