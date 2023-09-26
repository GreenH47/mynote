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
