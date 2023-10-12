[LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75)  

Companies 公司

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day, and an integer `fee` representing a transaction fee.  
您将获得一个数组 `prices` ，其中 `prices[i]` 是给定股票 `ith` 当天的价格，以及一个 `fee` 表示交易费用的整数。

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.  
找到您可以实现的最大利润。您可以完成任意数量的交易，但您需要为每笔交易支付交易费用。

**Note: 注意：**

- You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).  
    您不得同时进行多笔交易（即，您必须在再次买入之前卖出股票）。
- The transaction fee is only charged once for each stock purchase and sale.  
    每次股票买卖只收取一次交易费。

**Example 1: 示例 1：**

**Input:** prices = [1,3,2,8,4,9], fee = 2
**Output:** 8
**Explanation:** The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

**Example 2: 示例 2：**

**Input:** prices = [1,3,7,5,10,3], fee = 3
**Output:** 6

**Constraints: 约束：**

- `1 <= prices.length <= 5 * 104`
- `1 <= prices[i] < 5 * 104`
- `0 <= fee < 5 * 104`

```java
package org.leetcode;  
  
public class MaxProfit {  
    public int maxProfit(int[] prices, int fee) {  
        int n = prices.length;  
        int buy = -prices[0];  
        // Max money we can have if we have bought a stock on the ith day  
        int sell = 0;  
        // Max money we can have if we have sold a stock on the ith day  
  
        for (int i = 1; i < n; i++) {  
            int prevBuy = buy;  
            int prevSell = sell;  
  
            // Calculate the maximum money we can have if we buy a stock on the current day  
            buy = Math.max(prevSell - prices[i], prevBuy);  
            // Calculate the maximum money we can have if we sell a stock on the current day  
            sell = Math.max(prevBuy + prices[i] - fee, prevSell);  
        }  
  
        return sell;  
  
    }  
    public static void main(String[] args) {  
        MaxProfit maxProfit = new MaxProfit();  
  
        int[] prices1 = {1, 3, 2, 8, 4, 9};  
        int fee1 = 2;  
        int result1 = maxProfit.maxProfit(prices1, fee1);  
        int expect1 = 8;  
        if (result1 == expect1) {  
            System.out.println("Pass Max Profit 1: " + result1);  
        } else {  
            System.out.println("Fail expected: " + expect1 + " but got: " + result1);  
        }  
  
        int[] prices2 = {1, 3, 7, 5, 10, 3};  
        int fee2 = 3;  
        int result2 = maxProfit.maxProfit(prices2, fee2);  
        int expect2 = 6;  
        if (result2 == expect2) {  
            System.out.println("Pass Max Profit 2: " + result2);  
        } else {  
            System.out.println("Fail expected: " + expect2 + " but got: " + result2);  
        }  
  
        int[] prices3 = {4, 6, 2, 8, 3, 10, 14};  
        int fee3 = 3;  
        int result3 = maxProfit.maxProfit(prices3, fee3);  
        int expect3 = 11;  
        if (result3 == expect3) {  
            System.out.println("Pass Max Profit 3: " + result3);  
        } else {  
            System.out.println("Fail expected: " + expect3 + " but got: " + result3);  
        }  
    }  
  
}
```