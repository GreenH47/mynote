package org.leetcode;

public class CountBits {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            result[i] = result[i/2] + i%2;
        }
        return result;
    }
    public boolean compare(int[] result, int[] expected) {
        if (result.length != expected.length) {
            return false;
        } else {
            boolean status = true;
            for (int i = 0; i < result.length; i++) {
                if (result[i] != expected[i]) {
                    status = false;
                    break;
                }
            }
            return status;
        }
    }

    public static void main(String[] args) {
        CountBits obj = new CountBits();
        int input1 = 2;
        int[] result1 = obj.countBits(input1);
        int[] expected1 = {0, 1, 1};
        // compare result1 and expected1 value
        boolean status1 = obj.compare(result1, expected1);
        if (status1) {
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1 failed");
        }

        int input2 = 5;
        int[] result2 = obj.countBits(input2);
        int[] expected2 = {0, 1, 1, 2, 1, 2};
        // compare result2 and expected2 value
        boolean status2 = obj.compare(result2, expected2);
        if (status2) {
            System.out.println("Test2 passed");
        } else {
            System.out.println("Test2 failed");
        }
    }
}
