# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)  # Dummy head node
        current = head  # Pointer to the current node
        carry = 0  # Variable to store the carry value

        while l1 or l2 or carry:
            # Get the values of the current nodes, or 0 if one of them is None
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            # Calculate the sum of the current digits and the carry value
            total = val1 + val2 + carry

            # Calculate the carry for the next iteration
            carry = total // 10

            # Create a new node with the units digit of the sum
            current.next = ListNode(total % 10)

            # Move the pointers of the linked lists to the next nodes
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

            # Move the current pointer to the next node
            current = current.next

        return head.next

#     def addTwoNumbers_test(self):
#         l1 = [2, 4, 3]
#         l2 = [5, 6, 4]
#         output = [7, 0, 8]
#         assert self.addTwoNumbers(l1, l2) == output
#         print("Test 1: Passed")
#
# if __name__ == '__main__':
#     sol = Solution()
#     sol.addTwoNumbers_test()