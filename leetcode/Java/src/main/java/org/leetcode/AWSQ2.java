package org.leetcode;

import java.util.*;

public class AWSQ2 {
    public static long findBalancedSubsegments(List<Integer> capacity) {
        // Write your code here
        // print the list
        System.out.println("capacity: " + capacity);

        int serverSize = capacity.size();
        if (serverSize < 3) {
            return 0;
        }

        int balancedCount = 0;
        for (int i = 0; i < (serverSize - 2); i++) {

            for (int j = (serverSize-1); j > i; j--) {
                int sum = 0;
                List<Integer> index = new ArrayList<>();
                if (capacity.get(i).equals(capacity.get(j))) {
                    for (int k = i+1; k < j; k++) {
                        sum += capacity.get(k);
                        index.add(k);
                    }
                    if (sum == capacity.get(i)) {
                        balancedCount++;
                        System.out.println("sum: " + sum +
                                " index i: " + i +
                                " index j: "+ j+
                                " index: " + index);
                    }
                }
            }


        }
        return balancedCount;
    }


    public static void main(String[] args) {
        List<Integer> capacity1 = Arrays.asList(2,2,2,2,2);
        long balancedSubsegments1 = findBalancedSubsegments(capacity1);
        System.out.println(balancedSubsegments1); // Output: 3

        List<Integer> capacity2 = Arrays.asList(9,3,3,3,9);
        long balancedSubsegments2 = findBalancedSubsegments(capacity2);
        System.out.println(balancedSubsegments2); // Output: 2

    }


}
