def falling(n, k):
    """Compute the falling factorial of n to depth k.
    # >>> falling(6, 3)  # 6 * 5 * 4
    # 120
    # >>> falling(4, 3)  # 4 * 3 * 2
    # 24
    # >>> falling(4, 1)  # 4
    # 4
    # >>> falling(4, 0)
    # 1
    """
    "*** YOUR CODE HERE ***"
    ans = 1
    for i in range(n, n - k, -1):
        ans *= i
        return ans


def sum_digits(y):
    """Sum all the digits of y.
    Write a function that takes in a nonnegative integer
    and sums its digits. (Using floor division and
    modulo might be helpful here!)
    # >>> sum_digits(10) # 1 + 0 = 1
    # 1
    # >>> sum_digits(4224) # 4 + 2 + 2 + 4 = 12
    # 12
    # >>> sum_digits(1234567890)
    # 45
    # >>> a = sum_digits(123) # make sure that you are using return rather than print
    # >>> a
    # 6
    """
    "*** YOUR CODE HERE ***"
    sum_num = 0
    while y > 0:
        sum_num = sum_num + y % 10
        y = y // 10
    return sum_num


print(sum_digits(4224))


def double_eights(n):
    """Return true if n has two eights in a row.
    >>> double_eights(8)
    False
    >>> double_eights(88)
    True
    >>> double_eights(2882)
    True
    >>> double_eights(880088)
    True
    >>> double_eights(12345)
    False
    >>> double_eights(80808080)
    False
    """
    "*** YOUR CODE HERE ***"
    first8 = False
    second8 = False
    while n > 0:
        if n % 10 == 8:
            first8 = True
        else:
            first8 = False
        n = n //10
        if n % 10 == 8:
            return True
    return False


