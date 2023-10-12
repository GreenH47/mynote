package org.leetcode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        int[] nums1 = {2,2,1};
        int result1 = obj.singleNumber(nums1);
        int expected1 = 1;
        if (result1 == expected1) {
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1 failed");
        }

        int[] nums2 = {4,1,2,1,2};
        int result2 = obj.singleNumber(nums2);
        int expected2 = 4;
        if (result2 == expected2) {
            System.out.println("Test2 passed");
        } else {
            System.out.println("Test2 failed");
        }
    }
}
