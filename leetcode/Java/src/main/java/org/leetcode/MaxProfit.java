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

        int[] prices4 = {9,8, 7, 1,2};
        int fee4 = 3;
        int result4 = maxProfit.maxProfit(prices4, fee4);
        int expect4 = 0;
        if (result4 == expect4) {
            System.out.println("Pass Max Profit 4: " + result4);
        } else {
            System.out.println("Fail expected: " + expect4 + " but got: " + result4);
        }
    }

}
