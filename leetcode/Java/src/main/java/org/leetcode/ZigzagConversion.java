package org.leetcode;

public class ZigzagConversion {
    public String convert(String s, int numRows) {

        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public String convertMatrix(String s, int numRows) {

        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        }
        char[][] result = new char[numRows][s.length()];

        int currentRow = 0;
        boolean goingDown = false;
        int index = 0;

        for (char c : s.toCharArray()) {
            result[currentRow][index] = c;

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < index; j++) {
                if (result[i][j] != '\0') {
                    sb.append(result[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = zigzagConversion.convert(s1, numRows1);
        String expected1 = "PAHNAPLSIIGYIR";
        if (!result1.equals(expected1)) {
            System.out.println("Test failed for " + s1 + " with result " + result1);
        }
        else {
            System.out.println("Test passed for " + s1);
        }

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = zigzagConversion.convertMatrix(s2, numRows2);
        String expected2 = "PINALSIGYAHRPI";
        if (!result2.equals(expected2)) {
            System.out.println("Test failed for " + s2 + " with result " + result2);
        }
        else {
            System.out.println("Test passed for " + s2);
        }


    }
}
