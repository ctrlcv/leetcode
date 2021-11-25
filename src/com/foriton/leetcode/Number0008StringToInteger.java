package com.foriton.leetcode;

import java.nio.charset.StandardCharsets;

public class Number0008StringToInteger {
    public static void run() {
        System.out.println(myAtoi("042"));
    }

    public static int myAtoi(String s) {
        int result = 0;

        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; i++) {
            //
        }

        return result;
    }
}
