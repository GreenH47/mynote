package org.leetcode;
import java.util.*;
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                // remove the smallest element
                minHeap.remove();
            }
        }
        // the kth largest element is at the top of the heap
        return minHeap.peek();

    }

    public static void main(String[] args){
        FindKthLargest obj = new FindKthLargest();
        int[] nums1 = {3,2,1,5,6,4};
        int k1 = 2;
        int expect1 = 5;
        int result1 = obj.findKthLargest(nums1, k1);
        if (expect1 == result1) {
            System.out.println("Pass test 1");
        } else {
            System.out.println("Fail test 1, expect: " + expect1 + " but got: " + result1);
        }

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        int expect2 = 4;
        int result2 = obj.findKthLargest(nums2, k2);
        if (expect2 == result2) {
            System.out.println("Pass test 2");
        } else {
            System.out.println("Fail test 2, expect: " + expect2 + " but got: " + result2);
        }
    }
}
