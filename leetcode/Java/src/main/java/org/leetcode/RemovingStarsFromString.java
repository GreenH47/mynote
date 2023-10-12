package org.leetcode;

public class RemovingStarsFromString {
    public static String removeStars(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                result += s.charAt(i);
            }
            // if the current character is a star
            // and the result string is not empty
            // then remove the last character from the result string
            else{
                if(result.length() > 0){
                    result = result.substring(0, result.length() - 1);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String s1 = "leet**cod*e";
        String result1 = removeStars(s1);
        String expected1 = "lecoe";
        if (result1.equals(expected1)) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed expected: " + expected1 + " but got: " + result1);
        }

        String s2 = "erase*****";
        String result2 = removeStars(s2);
        String expected2 = "";
        if (result2.equals(expected2)) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed expected: " + expected2 + " but got: " + result2);
        }
    }
}
