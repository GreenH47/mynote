package org.leetcode;

import java.util.*;

public class StringCompression {
    public int compressDict(char[] chars) {
        int resultLength = 0;

        Dictionary<Character, Integer> dict = new Hashtable<>();
        for (int i = 0; i < chars.length; i++) {
            if (dict.get(chars[i]) == null) {
                dict.put(chars[i], 1);
            } else {
                dict.put(chars[i], dict.get(chars[i]) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Enumeration<Character> keys = dict.keys(); keys.hasMoreElements();) {
            Character key = keys.nextElement();
            result.append(key);
            result.append(dict.get(key));
        }

        String formattedString = result.toString();
        resultLength = formattedString.length();
        if (resultLength == 2){
            resultLength = 1;
        }

        return resultLength;
    }

    public int compress(char[] chars) {
        int start = 0;
        if (chars.length == 1){
            return 1;
        }
        StringBuilder sb = new StringBuilder("");
        while(start <= chars.length-1){
            sb.append(chars[start]);
            int count = 1;
            Character ch1 = chars[start];
            while(start < chars.length-1 && ch1.equals(chars[start+1])){
                start++;
                count++;
            }
            sb.append(count);
            start++;
        }
        sb.getChars(0,sb.length(),chars,0);

        int resultLength = sb.length();

        if (resultLength == 2){
            resultLength = 1;
        }
        return resultLength;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result1 = new StringCompression().compress(chars1);
        int expected1 = 6;
        if (result1 == expected1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed expected: " + expected1 + " but got: " + result1);
        }

        char[] chars2 = {'a'};
        int result2 = new StringCompression().compress(chars2);
        int expected2 = 1;
        if (result2 == expected2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed expected: " + expected2 + " but got: " + result2);
        }

        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int result3 = new StringCompression().compress(chars3);
        int expected3 = 4;
        if (result3 == expected3) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 failed expected: " + expected3 + " but got: " + result3);
        }


    }
}
