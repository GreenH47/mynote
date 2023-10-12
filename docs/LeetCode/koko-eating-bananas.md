[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75)  
Koko loves to eat bananas. There are `n` piles of bananas, the `ith` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.  
科科喜欢吃香蕉。有 `n` 一堆香蕉，那 `ith` 堆有 `piles[i]` 香蕉。警卫已经走了，几个小时后 `h` 就会回来。

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.  
科科可以决定她每小时吃香蕉的速度 `k` 。每个小时，她都会挑选一堆香蕉，然后从那堆香蕉中吃 `k` 香蕉。如果香蕉堆 `k` 少，她就把香蕉全部吃掉，在这个小时内不会再吃香蕉了。

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.  
科科喜欢慢慢吃，但还是想在警卫回来之前把所有的香蕉都吃完。

Return _the minimum integer_ `k` _such that she can eat all the bananas within_ `h` _hours_.  
返回最小整数 `k` ，以便她可以在 `h` 数小时内吃完所有香蕉。

**Example 1: 示例 1：**

**Input:** piles = [3,6,7,11], h = 8
**Output:** 4

**Example 2: 示例 2：**

**Input:** piles = [30,11,23,4,20], h = 5
**Output:** 30

**Example 3: 例3：**

**Input:** piles = [30,11,23,4,20], h = 6
**Output:** 23

**Constraints: 约束：**

- `1 <= piles.length <= 104`
- `piles.length <= h <= 109`
- `1 <= piles[i] <= 109`

```java

```