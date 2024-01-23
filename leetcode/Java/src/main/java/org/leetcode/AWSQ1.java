package org.leetcode;
import java.util.*;
public class AWSQ1 {
    public static List<Integer> predictDays(List<Integer> day, int k) {
        // Write your code here
        List<Integer> idealDays = new ArrayList<>();
        int n = day.size();

        for (int i = k; i < n - k; i++) {
            boolean isIdeal = true;

            // Check for non-increasing prior k days
            for (int j = i - k; j < i; j++) {
                if (day.get(j) < day.get(j + 1)) {
                    isIdeal = false;
                    break;
                }
            }

            // Check for non-decreasing following k days
            for (int j = i; j < i + k; j++) {
                if (day.get(j) > day.get(j + 1)) {
                    isIdeal = false;
                    break;
                }
            }

            if (isIdeal) {
                idealDays.add(i + 1);
            }
        }

        return idealDays;

    }

    public static void main(String[] args) {
        List<Integer> day1 = Arrays.asList(3, 2, 2, 2, 3, 4);
        int k1 = 2;
        List<Integer> idealDays1 = predictDays(day1, k1);
        System.out.println("Ideal Days 1: " + idealDays1);
        // Output: Ideal Days 1: [3, 4]

        List<Integer> day2 = Arrays.asList(1, 0, 1, 0, 1);
        int k2 = 1;
        List<Integer> idealDays2 = predictDays(day2, k2);
        System.out.println("Ideal Days 2: " + idealDays2);
        // Output: Ideal Days 2: [2, 4]
    }


}
