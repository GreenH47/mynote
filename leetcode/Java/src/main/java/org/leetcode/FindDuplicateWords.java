package org.leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class FindDuplicateWords {
    public static List<String> findDuplicates(String sentence) {
        List<String> duplicates = new ArrayList<>();
        Set<String> seenWords = new HashSet<>();
        String[] words = sentence.toLowerCase().split(" ");

        for (String word : words) {
            if (!seenWords.add(word)) {
                duplicates.add(word);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        // Test Case 1: Single duplicate word
        String sentence1 = "The dog is the best";
        List<String> duplicates1 = FindDuplicateWords.findDuplicates(sentence1);
        System.out.println("Duplicates in sentence1: " + duplicates1); // Expected output: ["the"]

        // Test Case 2: No duplicate words
        String sentence2 = "Happy thanksgiving, I am so full";
        List<String> duplicates2 = FindDuplicateWords.findDuplicates(sentence2);
        System.out.println("Duplicates in sentence2: " + duplicates2); // Expected output: []

        // Test Case 3: Multiple duplicate words
        String sentence3 = "Hello world, hello people";
        List<String> duplicates3 = FindDuplicateWords.findDuplicates(sentence3);
        System.out.println("Duplicates in sentence3: " + duplicates3); // Expected output: ["hello"]

        // Test Case 4: Case-insensitivity
        String sentence4 = "HeLlO hello hello";
        List<String> duplicates4 = FindDuplicateWords.findDuplicates(sentence4);
        System.out.println("Duplicates in sentence4: " + duplicates4); // Expected output: ["hello"]

        // Test Case 5: Empty string
        String sentence5 = "";
        List<String> duplicates5 = FindDuplicateWords.findDuplicates(sentence5);
        System.out.println("Duplicates in sentence5: " + duplicates5); // Expected output: []
    }
}
