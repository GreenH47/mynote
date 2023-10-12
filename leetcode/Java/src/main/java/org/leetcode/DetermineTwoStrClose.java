package org.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineTwoStrClose {
    public boolean closeStrings(String word1, String word2) {
        //boolean status = false;
        if (word1.length() != word2.length()) {
            return false;
        }


        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < word1.length() ; i++){
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0)+1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
        }

        for(int j= 0 ; j < word2.length() ;j++ ){
            if(!map.containsKey(word2.charAt(j))){
                return false;
            }
            if(!map2.containsKey(word1.charAt(j))){
                return false;
            }
        }



        ArrayList<Integer> list1 = new  ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            list1.add(entry.getValue());
        }
        for(Map.Entry<Character,Integer> entry : map2.entrySet()){
            list2.add(entry.getValue());
        }

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);

    }

    public static void main(String[] args) {
        DetermineTwoStrClose obj = new DetermineTwoStrClose();
        String word1_1 = "abc";
        String word1_2 = "bca";
        boolean result1 = obj.closeStrings(word1_1, word1_2);
        boolean expected1 = true;
        if (result1 == expected1) {
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1 failed result is " + result1 + " but expected is " + expected1);
        }

        String word2_1 = "cabbba";
        String word2_2 = "abbccc";
        boolean result2 = obj.closeStrings(word2_1, word2_2);
        boolean expected2 = true;
        if (result2 == expected2) {
            System.out.println("Test2 passed");
        } else {
            System.out.println("Test2 failed result is " + result2 + " but expected is " + expected2);
        }
    }
}
