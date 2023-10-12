package org.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            if(currentArea > area) {
                area = currentArea;
            }
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int result1 = containerWithMostWater.maxArea(height1);
        int expected1 = 49;
        if(result1 == expected1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed expected: " + expected1 + " actual: " + result1);
        }
    }
}
