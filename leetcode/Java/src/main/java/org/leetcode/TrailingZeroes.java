package org.leetcode;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {

            n = n / 5;
            result += n;
        }

        return result;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        int n1 = 3;
        int result1 = trailingZeroes.trailingZeroes(n1);
        int expected1 = 0;
        if (result1 != expected1) {
            System.out.println("Expected: " + expected1 + ", but was: " + result1);
        }
        else{
            System.out.println("Test passed for " + n1 + " with result " + result1);
        }
    }
}
