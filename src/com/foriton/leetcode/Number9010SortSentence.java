package com.foriton.leetcode;


import java.util.Arrays;

public class Number9010SortSentence {
    public static void run() {
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }

    public static String sortSentence(String s) {
        String[] resultArray = s.split(" ");
        String resultStr = "";

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultArray[i].substring(resultArray[i].length() - 1, resultArray[i].length()) + resultArray[i].substring(0, resultArray[i].length() - 1);
//            System.out.println(resultArray[i]);
        }
        
        Arrays.sort(resultArray);

        for (int i = 0; i < resultArray.length; i++) {
            if (i != 0) {
                resultStr = resultStr + " ";
            }

            resultStr += resultArray[i].substring(1);
        }

        return resultStr;
    }
}
