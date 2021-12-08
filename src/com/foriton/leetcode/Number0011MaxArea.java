package com.foriton.leetcode;

public class Number0011MaxArea {
    public static void run() {
        int[] input = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;

//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int boxWidth = j - i;
//                int boxHeight = (height[i] < height[j]) ? height[i] : height[j];
//
//                int boxArea = boxWidth * boxHeight;
//
//                if (boxArea > maxArea) {
//                    maxArea = boxArea;
//                }
//            }
//        }
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int boxArea = 0;

            if (height[start] < height[end]) {
                boxArea = (end - start) * height[start];
            } else {
                boxArea = (end - start) * height[end];
            }

            if (boxArea > maxArea) {
                maxArea = boxArea;
            }

            int shortHeight;
            if (height[start] < height[end]) {
                shortHeight = height[start];
                while(height[start] <= shortHeight && start < end) {
                    start++;
                }
            } else {
                shortHeight = height[end];
                while(height[end] <= shortHeight && start < end) {
                    end--;
                }
            }
        }

        return maxArea;
    }
}
