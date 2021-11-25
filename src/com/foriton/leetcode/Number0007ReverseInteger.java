package com.foriton.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//============================================================================================
// 정수를 이어 붙여서 만들수 있는 가장 큰 수 구하기
//============================================================================================
public class Number0007ReverseInteger {
    public static void run() {
        int numbers[] = {0,0,0,0};//{3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        ArrayList<String> numList = new ArrayList<>();

        for (int i = 0; i< numbers.length; i++) {
            numList.add(String.valueOf(numbers[i]));
        }

        Collections.sort(numList, new StringComparator().reversed());

        String answer = "";
        for (String s : numList) {
            answer += s;
        }

        int startIndex = 0;
        for (int i = 0 ; i < answer.length(); i++) {
            if (answer.charAt(i) != '0') {
                break;
            }

            startIndex = i;
        }

        return answer.substring(startIndex);
    }

    static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String number1, String number2) {
            return CompareNumStr(number1, number2);
        }

        int CompareNumStr(String number1, String number2) {
            if (number1.length() == number2.length()) {
                return Integer.compare(Integer.parseInt(number1), Integer.parseInt(number2));
            }

            if (number1.length() > number2.length()) {
                String number1SubStr = number1.substring(0, number2.length());
                int result = CharSequence.compare(number1SubStr, number2);
                if (result != 0) {
                    return result;
                }

                return CompareNumStr(number1.substring(number2.length()), number2);
            } else {
                String number2SubStr = number2.substring(0, number1.length());
                int result = CharSequence.compare(number1, number2SubStr);
                if (result != 0) {
                    return result;
                }

                return CompareNumStr(number1, number2.substring(number1.length()));
            }
        }
    }

    public String solution1(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }

        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}
