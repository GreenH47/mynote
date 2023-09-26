[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/add-two-numbers/) 
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.  
您将获得两个非空链表，代表两个非负整数。数字以相反的顺序存储，其每个节点都包含一个数字。将两个数字相加，并将总和作为链表返回。

You may assume the two numbers do not contain any leading zero, except the number 0 itself.  
您可以假设这两个数字不包含任何前导零，除了数字 0 本身。

**Example 1: 示例 1：**

![](https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg)

**Input:** l1 = [2,4,3], l2 = [5,6,4]
**Output:** [7,0,8]
**Explanation:** 342 + 465 = 807.

**Example 2: 示例 2：**

**Input:** l1 = [0], l2 = [0]
**Output:** [0]

**Example 3: 例3：**

**Input:** l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
**Output:** [8,9,9,9,0,0,0,1]

**Constraints: 约束：**

- The number of nodes in each linked list is in the range `[1, 100]`.  
    每个链表中的节点数在 `[1, 100]` 范围内。
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.  
    保证列表表示没有前导零的数字。

```python
# Definition for singly-linked list.  
class ListNode(object):  
    def __init__(self, val=0, next=None):  
        self.val = val  
        self.next = next  
  
class Solution(object):  
    def addTwoNumbers(self, l1, l2):  
        """  
        :type l1: ListNode        :type l2: ListNode        :rtype: ListNode  
        """        head = ListNode(0)  # Dummy head node  
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
```

1. Create a dummy head node and initialize a pointer `current` to it.  
    创建一个虚拟头节点并初始化指向它的指针 `current` 。
2. Initialize a variable `carry` to 0 to store the carry value.  
    将变量 `carry` 初始化为 0 以存储进位值。
3. Iterate through both linked lists simultaneously using a while loop while either of the linked lists or the carry value exists.  
    当链表或进位值存在时，使用 while 循环同时循环访问两个链表。
4. Get the values of the current nodes `val1` and `val2`, or 0 if one of them is None.  
    获取当前节点的值， `val2` 如果其中一个节点 `val1` 为 None，则为 0。
5. Calculate the sum of the current digits and the carry value, and store it in `total`.  
    计算当前数字和账位价值的总和，并将其存储在 `total` .
6. Calculate the carry for the next iteration by dividing `total` by 10.  
    除以 `total` 10 计算下一次迭代的进位。
7. Create a new node with the units digit of `total` and set the next pointer of the `current` node to it.  
    创建一个单位数字为 的新 `total` 节点，并将节点的下一个指针设置为该 `current` 节点。
8. Move the pointers of the linked lists to the next nodes if they exist.  
    将链表的指针移动到下一个节点（如果存在）。
9. Move the `current` pointer to the next node.  
    将 `current` 指针移动到下一个节点。
10. Once the while loop finishes, return the next pointer of the dummy head node.  
    while 循环完成后，返回虚拟头节点的下一个指针。