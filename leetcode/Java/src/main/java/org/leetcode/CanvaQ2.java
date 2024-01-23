package org.leetcode;

import java.util.*;

public class CanvaQ2 {
    /*
     * Complete the 'findMinCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY efficiency as parameter.
     */

    public static int findMinCost(List<Integer> efficiency) {
        // Sort the efficiency ratings in ascending order
        Collections.sort(efficiency);
        System.out.println("Sorted efficiency: ");
        System.out.println(efficiency);

        int workerSize = efficiency.size();
        int[] costs = new int[workerSize];

        for (int i = 0; i < workerSize; i++) {
            int cost = 0;
            List<Integer> reducedEfficiency = new ArrayList<>(efficiency);
            reducedEfficiency.remove(i);

            for (int j = 0; j < workerSize - 2; j += 2) {
                int pairCost = Math.abs(reducedEfficiency.get(j) - reducedEfficiency.get(j + 1));
                cost += pairCost;
            }

            costs[i] = cost;
        }

        // Find the minimum cost from the costs array
        int minCost = Integer.MAX_VALUE;
        for (int cost : costs) {
            minCost = Math.min(minCost, cost);
        }
        System.out.println("Every worker efficiency: ");
        System.out.println(Arrays.toString(costs));
        return minCost;

    }
    public static void main(String[] args) {
        List<Integer> efficiency1 = Arrays.asList(4, 2, 8, 1, 9);
        List<Integer> efficiency2 = Arrays.asList(2, 13, 12, 9, 6, 3, 2);

        int minCost1 = CanvaQ2.findMinCost(efficiency1);
        // Output the minimum costs
        System.out.println("Minimum cost 1: " + minCost1);
        int minCost2 = CanvaQ2.findMinCost(efficiency2);


        // Output: Minimum cost 1: 2

        System.out.println("Minimum cost 2: " + minCost2);
        // Output: Minimum cost 2: 4

    }



}
