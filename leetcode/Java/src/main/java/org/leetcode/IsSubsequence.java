package org.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean isSubsequence = false;
        int sLength = s.length();
        int tLength = t.length();

        if (sLength > tLength) {
            return isSubsequence;
        }
        if (sLength == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    isSubsequence = true;
                    break;
                }
            }
            tIndex++;
        }



        return isSubsequence;
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        String s1 = "abc";
        String t1 = "ahbgdc";
        boolean expect1 = obj.isSubsequence(s1, t1);
        boolean result1 = true;
        if (expect1 == result1) {
            System.out.println("test 1 Pass");
        } else {
            System.out.println("Fail expected: " + expect1 + " but got: " + result1);
        }

        String s2 = "axc";
        String t2 = "ahbgdc";
        boolean expect2 = obj.isSubsequence(s2, t2);
        boolean result2 = false;
        if (expect2 == result2) {
            System.out.println("test 2 Pass");
        } else {
            System.out.println("Fail expected: " + expect2 + " but got: " + result2);
        }
    }
}
