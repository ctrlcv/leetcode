package com.foriton.leetcode;

import java.nio.charset.StandardCharsets;

public class Number0008StringToInteger {
    public static void run() {
        System.out.println(myAtoi("+-45"));
    }

    public static int myAtoi(String s) {
        int result = 0;
        boolean isMinus = false;
        boolean isDecidePlusMinus = false;

        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; i++) {
            byte num = bytes[i];

            // " "
            if (num == 0x20 && result == 0 && !isDecidePlusMinus) {
                continue;
            }

            // "-"
            if (num == 0x2D && result == 0 && !isDecidePlusMinus) {
                isMinus = true;
                isDecidePlusMinus = true;
                continue;
            }

            // "+"
            if (num == 0x2B && result == 0 && !isDecidePlusMinus) {
                isMinus = false;
                isDecidePlusMinus = true;
                continue;
            }

            if (num < 0x30 || num > 0x39) {
                if (isMinus) {
                    result = result * -1;
                }
                return result;
            }

            isDecidePlusMinus = true;

            if ((result > 214748364) || (result == 214748364 && num >= 0x38)) {
                if (isMinus) {
                    return -2147483648;
                } else {
                    return 2147483647;
                }
            }

            result = result * 10 + num - 0x30;
            System.out.println("result [" + i + "] : " + result);
        }

        if (isMinus) {
            result = result * -1;
        }

        return result;
    }
}
