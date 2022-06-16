package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class FindMaxNum {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 20, 30, 1, 0, 2, 45, 788, 45, 1, 5};

        int maxIndex = 0;

        for (int i = 1; i < ints.length; i++) {
            if (ints[maxIndex] < ints[i]) {
                maxIndex = i;
            }
        }

        System.out.println("最大元素下标是: " + maxIndex +", 对应值是: " + ints[maxIndex]);

    }
}
