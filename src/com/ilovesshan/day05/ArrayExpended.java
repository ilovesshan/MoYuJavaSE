package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class ArrayExpended {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 20, 30};

        // 将ints长度+1, 让ints[3] = 40;

        int[] temp = new int[ints.length + 1];

        for (int i = 0; i < ints.length; i++) {
            temp[i] = ints[i];
        }

        ints = temp;

        ints[3] = 40;

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
