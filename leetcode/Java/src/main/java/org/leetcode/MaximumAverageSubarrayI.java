package org.leetcode;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }

        int i = k;
        int j = 0;
        double result = sum/k;
        while(i < nums.length) {
            sum += nums[i];
            sum -= nums[j];
            result = Math.max(result, sum/k);
            i++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[] nums1 = {1,12,-5,-6,50,3};
        int k1 = 4;
        double result1 = maximumAverageSubarrayI.findMaxAverage(nums1, k1);
        double expected1 = 12.75;
        if(result1 == expected1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed expected: " + expected1 + " actual: " + result1);
        }

        int[] nums2 = {5};
        int k2 = 1;
        double result2 = maximumAverageSubarrayI.findMaxAverage(nums2, k2);
        double expected2 = 5;
        if(result2 == expected2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed expected: " + expected2 + " actual: " + result2);
        }
    }
}
