package org.leetcode;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");


        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = words[words.length - 1 - i];
        }

        String reversedSentence = String.join(" ", reversedWords);
        // delete the last space
        return reversedSentence.trim();
    }

    public static void main(String[] args) {
        String sentence1 = "The dog is the best";
        String reversedSentence1 = new ReverseWordsInString().reverseWords(sentence1);
        System.out.println("Reversed sentence1: " + reversedSentence1); // Expected output: "best the is dog The"

        String sentence2 = "  hello world  ";
        String reversedSentence2 = new ReverseWordsInString().reverseWords(sentence2);
        System.out.println("Reversed sentence2: " + reversedSentence2); // Expected output: "full so am I thanksgiving, Happy"


        String sentence3 = "a good   example";
        String reversedSentence3 = new ReverseWordsInString().reverseWords(sentence3);
        System.out.println("Reversed sentence3: " + reversedSentence3); // Expected output: "example good a"
    }
}
