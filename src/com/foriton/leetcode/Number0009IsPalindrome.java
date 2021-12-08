package com.foriton.leetcode;

public class Number0009IsPalindrome {
    public static void run() {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String number =  Integer.toString(x);
        System.out.println("Start:" + number);

        while (number.length() > 1) {
            if (number.charAt(0) != number.charAt(number.length() - 1)) {
                return false;
            }

            number = number.substring(1, number.length() - 1);
//            System.out.println(number);
        }

        return true;
    }
}
