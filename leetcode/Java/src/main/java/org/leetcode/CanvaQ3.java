package org.leetcode;
import java.util.*;
public class CanvaQ3 {
    public static int getMaxTime(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize the adjacency list
        for (int i = 1; i <= gNodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build the adjacency list from gFrom and gTo lists
        for (int i = 0; i < gFrom.size(); i++) {
            int from = gFrom.get(i);
            int to = gTo.get(i);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int maxTime = 0;

        // Perform DFS from each server and update the maxTime
        for (int server = 1; server <= gNodes; server++) {
            boolean[] visited = new boolean[gNodes + 1];
            int time = dfs(graph, server, visited);
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int server, boolean[] visited) {
        visited[server] = true;
        int maxTime = 0;

        for (int neighbor : graph.get(server)) {
            if (!visited[neighbor]) {
                int time = 1 + dfs(graph, neighbor, visited);
                maxTime = Math.max(maxTime, time);
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        int gNodes = 3;
        List<Integer> gFrom = Arrays.asList(1, 2);
        List<Integer> gTo = Arrays.asList(2, 3);

        int maxTime = CanvaQ3.getMaxTime(gNodes, gFrom, gTo);

        // Output the maximum time
        System.out.println("Maximum Time: " + maxTime);
        // Output: Maximum Time: 2
    }
}
