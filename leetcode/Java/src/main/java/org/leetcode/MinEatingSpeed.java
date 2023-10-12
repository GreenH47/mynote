package org.leetcode;

public class MinEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(blackbox(mid,piles,h)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
    }
    public static boolean blackbox(int maxpiles, int[] piles, int h){
        int hours=0;
        for(int i:piles){
            int time=i/maxpiles;
            hours+=time;
            if(i%maxpiles!=0) hours++;
        }
        if(hours<=h)
            return true;
        return false;
    }



    public static void main(String[] args) {
        int[] piles1 = {3,6,7,11};
        int h1 = 8;
        int result1 = minEatingSpeed(piles1, h1);
        int expected1 = 4;
        if (result1 == expected1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed with result: " + result1 + " and expected: " + expected1);
        }


        int[] piles2 = {30,11,23,4,20};
        int h2 = 5;
        int result2 = minEatingSpeed(piles2, h2);
        int expected2 = 30;
        if (result2 == expected2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed with result: " + result2 + " and expected: " + expected2);
        }

        int[] piles3 = {312884470};
        int h3 = 312884469;
        int result3 = minEatingSpeed(piles3, h3);
        int expected3 = 2;
        if (result3 == expected3) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 failed with result: " + result3 + " and expected: " + expected3);
        }
    }


}
