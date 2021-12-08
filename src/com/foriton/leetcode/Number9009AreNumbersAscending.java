package com.foriton.leetcode;

public class Number9009AreNumbersAscending {
    public static void run() {
        System.out.println(areNumbersAscending("4 5 11 26"));
    }

    public static boolean areNumbersAscending(String s) {
        String[] resultArray = s.split(" ");
        int lastNumber = -1;

        for (int i = 0; i < resultArray.length; i++) {
            int thisNumber;

            try {
                thisNumber = Integer.parseInt(resultArray[i]);
            } catch (NumberFormatException e) {
                continue;
            }

            if (lastNumber >= thisNumber) {
                return false;
            }

            lastNumber = thisNumber;
        }

        return true;
    }
}
