Create time: 2023-01-05  Last update: 2023-01-11
# Reference
[Courese material](https://cs61a.org/ )    
[solution](https://github.com/xuyanshi/cs61a)  
[python code visualization](https://pythontutor.com/cp/composingprograms.html#mode=display)

# Week 1  function
##  hw01
### Q1 A Plus Abs B
> Fill in the blanks in the following function for adding `a` to the absolute value of `b`, without calling `abs`. You may **not** modify any of the provided code other than the two blanks.  

```py
from operator import add, sub
def a_plus_abs_b(a, b):
    """Return a+abs(b), but without calling abs.
    >>> a_plus_abs_b(2, 3)
    5
    >>> a_plus_abs_b(-1, -4)
    3
    """
    if b < 0:
        f = sub
    else:
        f = add
    return f(a, b)
```

### Q2: Two of Three
> Write a function that takes three _positive_ numbers as arguments and returns the sum of the squares of the two smallest numbers. **Use only a single line for the body of the function.**  

```py
def two_of_three(i, j, k):
"""
Return m*m + n*n, where m and n are the two smallest members of the positive numbers i, j, and k.
>>> two_of_three(1, 2, 3)
5
>>> two_of_three(5, 5, 5)
50
"""
	return i**2+j**2+k**2-max(i,j,k)**2
```

### Q3: Largest Factor
> Write a function that takes an integer `n` that is **greater than 1** and returns the largest integer that is smaller than `n` and evenly divides `n`.

```py
def largest_factor(n):
    """
    Return the largest factor of n that is smaller than n.
    >>> largest_factor(15) 
    >>> # factors are 1, 3, 5
    5
    >>> largest_factor(80) # factors are 1, 2, 4, 5, 8, 10, 16, 20, 40
    40
    >>> largest_factor(13) # factor is 1 since 13 is prime
    1
    """
    factor=0
    for i in range(1,n):
        if n%i==0:
            factor=i
    return factor
```

### Q4: Hailstone

Douglas Hofstadter's Pulitzer-prize-winning book, _Gödel, Escher, Bach_, poses the following mathematical puzzle.

1.  Pick a positive integer `n` as the start.
2.  If `n` is even, divide it by 2.
3.  If `n` is odd, multiply it by 3 and add 1.
4.  Continue this process until `n` is 1.

The number `n` will travel up and down but eventually end at 1 (at least for all numbers that have ever been tried -- nobody has ever proved that the sequence will terminate). Analogously, a hailstone travels up and down in the atmosphere before eventually landing on earth.

This sequence of values of `n` is often called a Hailstone sequence. Write a function that takes a single argument with formal parameter name `n`, prints out the hailstone sequence starting at `n`, and returns the number of steps in the sequence:
```py
def hailstone(n):
    """
    Print the hailstone sequence starting at n and return its length.
    >>> a = hailstone(10)
    10
    5
    16
    8
    4
    2
    1

    >>> a
    7
    """

    length = 1
    while n != 1:
        print(n)
        if n % 2 == 0:
            n = n // 2      # Integer division prevents "1.0" output
        else:
            n = 3 * n + 1
        length = length + 1
    print(n)   # n is now 1
    return length
```

# Week2  control environment
## different between break return continue
![](../img/cs61a-20230110.png)  
```py
def name_length(names):
    i = 0
    for name in names:
            i = i+1
            print(name)
            print(i)
            if name == "Nina":
                    break
					# continue
					# return "Found the special name"
    print(i)
names = ["Max", "Nina", "Rose"]
name_length(names)

```
## lab001
### Q5: Falling Factorial
Let's write a function `falling`, which is a "falling" factorial that takes two arguments, `n` and `k`, and returns the product of `k` consecutive numbers, starting from `n` and working downwards. When `k` is 0, the function should return 1.   
```py
def falling(n, k):
"""Compute the falling factorial of n to depth k.
>>> falling(6, 3) # 6 * 5 * 4
120
>>> falling(4, 3) # 4 * 3 * 2
24
>>> falling(4, 1) # 4
4
>>> falling(4, 0)
1
"""
"*** YOUR CODE HERE ***"
ans = 1
for i in range(n,n-k,-1):
	ans *= i
	return ans
```

### Q6: Sum Digits

Write a function that takes in a nonnegative integer and sums its digits. (Using floor division and modulo might be helpful here!)
```py
def sum_digits(y):
"""Sum all the digits of y.
>>> sum_digits(10) # 1 + 0 = 1
1
>>> sum_digits(4224) # 4 + 2 + 2 + 4 = 12
12
>>> sum_digits(1234567890)
45
>>> a = sum_digits(123) # make sure that you are using return rather than print
>>> a
6
"""
"*** YOUR CODE HERE ***"
	ans=0
	while y>0:
		ans = ans + y%10
		y = y // 10
	return ans
```

### Q8
```py
def double_eights(n):  
    """
    Return true if n has two eights in a row.  
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
```
## Iteration The Fibonacci Sequence
```py
def fib(n):
    """Compute the nth Fibonacci number, for N >= 1."""
    pred, curr = 0, 1 # 0th and 1st Fibonacci numbers
    k = 1 # curr is the kth Fibonacci number
    while k < n:
        pred, curr = curr, pred + curr # The next Fibonacci number is the sum of the current one and its predecessor
        k = k + 1
    return curr
#print(fib(6))
```
## Conditional statements
-   The `elif` and `else` clauses are optional, and you can have any number of `elif` clauses.
-   A **conditional expression** is an expression that evaluates to either a truthy value (`True`, a non-zero integer, etc.) or a falsy value (`False`, `0`, `None`, `""`, `[]`, etc.).
-   Only the first `if`/`elif` expression that evaluates to a **truthy** value will have its corresponding indented suite be executed.
-   If none of the conditional expressions evaluate to a true value, then the `else` suite is executed. There can only be one `else` clause in a conditional statement.
```py
if <conditional expression>: <suite of statements> 
elif <conditional expression>: <suite of statements> 
else: <suite of statements>
```  

```py
def special_case():
    x = 10
    if x > 0:
        x += 2
    elif x < 13:
        x += 3
    elif x % 2 == 1:
        x += 4
    return x

print(special_case()) # 12
```
```py
def special_case():
    x = 10
    if x > 0:
        x += 2
    if x < 13:
        x += 3
    if x % 2 == 1:
        x += 4
    return x

print(special_case()) # 19
```
```py
def special_case():
    x = 10
    if x > 0:
        return x + 2
    if x < 13:
        return x + 3
    if x % 2 == 1:
        return x + 4
    return x

print(special_case())  # 12
```

### Q4: Is Prime?
Write a function that returns `True` if a positive integer `n` is a prime number and `False` otherwise.

A prime number n is a number that is not divisible by any numbers other than 1 and n itself. For example, 13 is prime, since it is only divisible by 1 and 13, but 14 is not, since it is divisible by 1, 2, 7, and 14.

**Hint:** Use the `%` operator: `x % y` returns the remainder of `x` when divided by `y`.
```py
def is_prime(n):
    # returns True if a positive integer n 
    # is a prime number and False otherwise.
    if isinstance(n,int):
        if n == 2 or n == 3:
            return True
        if n == 4 or n == 1:
            return False
        if n > 4:
            b = int( n / 2)
            for i in range(2,b):
                if (n % i) == 0:
                    return False
            return True
        
    else:
        return False
# print(is_prime(10))
```
### Q5: Fizzbuzz

Implement the fizzbuzz sequence, which prints out a _single statement_ for each number from 1 to `n`. For a number `i`,

-   If `i` is divisible by 3 only, then we print "fizz".
-   If `i` is divisible by 5 only, then we print "buzz".
-   If `i` is divisible by both 3 and 5, then we print "fizzbuzz".
-   Otherwise, we print the number `i` by itself.

Implement `fizzbuzz(n)` here:
```py
def fizzbuzz(n):
    i = 1
    while i <= n:
        if i % 3 == 0 and i % 5 == 0:
            print('fizzbuzz')
        elif i % 3 == 0:
            print('fizz')
        elif i % 5 == 0:
            print('buzz')
        else:
            print(i)
        i += 1
result = fizzbuzz(16)
```
### Q6: Unique Digits

Write a function that returns the number of unique digits in a positive integer.

> **Hints:** You can use `//` and `%` to separate a positive integer into its one's digit and the rest of its digits.
> 
> You may find it helpful to first define a function `has_digit(n, k)`, which determines whether a number `n` has digit `k`.
```py
def has_digit(n, k):
    """Returns whether K is a digit in N.
    >>> has_digit(10, 1)
    True
    >>> has_digit(12, 7)
    False
    """
    while n > 0:
        last = n % 10
        n = n // 10
        if last == k:
            return True
    return False
# print(has_digit(12, 7))

def unique_digits(n):
    """Return the number of unique digits in positive integer n.

    >>> unique_digits(8675309) # All are unique
    7
    >>> unique_digits(1313131) # 1 and 3
    2
    >>> unique_digits(13173131) # 1, 3, and 7
    3
    >>> unique_digits(10000) # 0 and 1
    2
    >>> unique_digits(101) # 0 and 1
    2
    >>> unique_digits(10) # 0 and 1
    2
    """
    unique = 0
    while n > 0:
        last = n % 10
        n = n // 10
        if not has_digit(n, last):
            unique =  unique + 1
    return unique
# print(unique_digits(13173131))
```
# Project 1: The Game of Hog
https://inst.eecs.berkeley.edu/~cs61a/fa22/proj/hog/
## Problem 1 roll_dice()
```py
def roll_dice(num_rolls, dice=six_sided):  
    """Simulate rolling the DICE exactly NUM_ROLLS > 0 times. Return the sum of  
    the outcomes unless any of the outcomes is 1. In that case, return 1.  
    num_rolls:  The number of dice rolls that will be made.    dice:       A function that simulates a single dice roll outcome.    """    # These assert statements ensure that num_rolls is a positive integer.  
    assert type(num_rolls) == int, 'num_rolls must be an integer.'  
    assert num_rolls > 0, 'Must roll at least once.'  
    # BEGIN PROBLEM 1  
    "*** YOUR CODE HERE ***"  
    sow_sad = False  
    sum_pts = 0  
    for i in range(num_rolls):  
        roll_pts = dice()  
        if roll_pts == 1:  
            sow_sad = True  
        sum_pts = sum_pts + roll_pts  
    if sow_sad:  
        sum_pts = 1  
    return sum_pts  
    # print(num_rolls)  
    # END PROBLEM 1
```
## problem 2 tail_points()
```py
def tail_points(opponent_score):  
    """Return the points scored by rolling 0 dice according to Pig Tail.  
  
    opponent_score:   The total score of the other player.  
    """    # BEGIN PROBLEM 2  
    "*** YOUR CODE HERE ***"  
    a = opponent_score % 10  
    b = (opponent_score//10) % 10  
    pts = 0  
    if a > b:  
        pts = 2 * (a - b) + 1  
    else:  
        pts = 2 * (b - a) + 1  
    return pts  
    # END PROBLEM 2
```
## problem 3 take_turn()
```py
def take_turn(num_rolls, opponent_score, dice=six_sided):  
    """Return the points scored on a turn rolling NUM_ROLLS dice when the  
    opponent has OPPONENT_SCORE points.  
    num_rolls:       The number of dice rolls that will be made.    opponent_score:  The total score of the other player.    dice:            A function that simulates a single dice roll outcome.    """    # Leave these assert statements here; they help check for errors.  
    assert type(num_rolls) == int, 'num_rolls must be an integer.'  
    assert num_rolls >= 0, 'Cannot roll a negative number of dice in take_turn.'  
    assert num_rolls <= 10, 'Cannot roll more than 10 dice.'  
    # BEGIN PROBLEM 3  
    "*** YOUR CODE HERE ***"  
    if num_rolls == 0:  
        return tail_points(opponent_score)  
    else:  
        return roll_dice(num_rolls,dice)  
    # END PROBLEM 3
```
## problem 4
```py
def perfect_square(score):  
    n = 0  
    for n in range(1,score):  
        if n * n == score:  
            return True  
    return False  
  
def next_perfect_square(score):  
    n = 0  
    for n in range(1, score):  
        if n * n == score:  
            break  
    return (n + 1) * (n + 1)
```
 ## problem 5  
 
```py
 def play(strategy0, strategy1, update,  
         score0=0, score1=0, dice=six_sided, goal=GOAL):  
    """Simulate a game and return the final scores of both players, with  
    Player 0's score first and Player 1's score second.  
    E.g., play(always_roll_5, always_roll_5, square_update) simulates a game in    which both players always choose to roll 5 dice on every turn and the Square    Swine rule is in effect.  
    A strategy function, such as always_roll_5, takes the current player's    score and their opponent's score and returns the number of dice the current    player chooses to roll.  
    An update function, such as square_update or simple_update, takes the number    of dice to roll, the current player's score, the opponent's score, and the    dice function used to simulate rolling dice. It returns the updated score    of the current player after they take their turn.  
    strategy0: The strategy for player0.    strategy1: The strategy for player1.    update:    The update function (used for both players).    score0:    Starting score for Player 0    score1:    Starting score for Player 1    dice:      A function of zero arguments that simulates a dice roll.    goal:      The game ends and someone wins when this score is reached.    """    
    who = 0  # Who is about to take a turn, 0 (first) or 1 (second)  
    # BEGIN PROBLEM 5    
    "*** YOUR CODE HERE ***"  
    while score0 < goal and score1 < goal:  # check if someone win  
        if who == 0:  # player 0 turn  
            num_dice = strategy0(score0, score1)  
            score0 = update(num_dice, score0, score1)  
        else:  
            num_dice = strategy0(score1, score0)  
            score1 = update(num_dice, score1, score0)  
  
    # END PROBLEM 5  
    return score0, score1
```
## assert()
The `assert` keyword lets you test if a condition in your code returns True, if not, the program will raise an AssertionError.
```py
x = "hello"

#if condition returns True, then nothing happens:
assert x == "hello"

#if condition returns False, AssertionError is raised:
assert x == "goodbye"
```

##  problem 6
```py
def always_roll(n):  
    """Return a player strategy that always rolls N dice.  
  
    A player strategy is a function that takes two total scores as arguments    (the current player's score, and the opponent's score), and returns a    number of dice that the current player will roll this turn.  
    # >>> strategy = always_roll(3)    # >>> strategy(0, 0)    # 3    # >>> strategy(99, 99)    # 3    """    assert n >= 0 and n <= 10  
    # BEGIN PROBLEM 6  
    "*** YOUR CODE HERE ***"  
    return n  
    # END PROBLEM 6
```

##  problem 7
```py
def is_always_roll(strategy, goal=GOAL):  
    """Return whether strategy always chooses the same number of dice to roll.  
  
    # >>> is_always_roll(always_roll_5)    # True    # >>> is_always_roll(always_roll(3))    # True    # >>> is_always_roll(catch_up)    # False    """    # BEGIN PROBLEM 7  
    "*** YOUR CODE HERE ***"  
    dice_num = strategy(0, 0)  
    for score in range(goal):  
        for oppo_score in range(goal):  
            curr_num = strategy(score, oppo_score)  
            if curr_num != dice_num:  
                return False  
    return True    # END PROBLEM 7
```
## *args
https://realpython.com/python-kwargs-and-args/
it allows you to pass a varying number of positional arguments.
```py
# sum_integers_args.py
def my_sum(*args):
    result = 0
    # Iterating over the Python args tuple
    for x in args:
        result += x
    return result

print(my_sum(1, 2, 3))
```
## problem 8
