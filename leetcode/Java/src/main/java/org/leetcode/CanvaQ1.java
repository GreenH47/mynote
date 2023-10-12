package org.leetcode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CanvaQ1 {
    /*
     * Complete the 'getLatestKRequests' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER K
     */

    public static List<String> getLatestKRequests(List<String> requests, int K) {
        // Write your code here
        List<String> result = new ArrayList<>();
        Set<String> distinctRequests = new HashSet<>();

        // Traverse the requests in reverse order
        for (int i = requests.size() - 1; i >= 0; i--) {
            String request = requests.get(i);

            // Skip duplicates
            if (distinctRequests.contains(request)) {
                continue;
            }

            // Add the distinct request to the result list
            result.add(request);
            distinctRequests.add(request);

            // Break if we have collected K requests
            if (result.size() == K) {
                break;
            }
        }

        // Reverse the result list to get the most recent requests first
        //Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        List<String> requests1 = Arrays.asList("item 3", "item2", "item1", "item2", "item3");
        int K1 = 3;
        CanvaQ1 canvaQ1 = new CanvaQ1();

        List<String> result1 = canvaQ1.getLatestKRequests(requests1, K1);

        // Output the resulting list
        System.out.println("Recent requests: " + result1);
        // Output: Recent requests: [item3, item1, item2]
    }

}
