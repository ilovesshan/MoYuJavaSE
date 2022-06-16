package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class IteratorArray {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 20, 30, 1, 0, 2, 45, 788, 45, 1, 5};

        // for 循环
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        // while 循环
        int i = 0;
        while (i < ints.length) {
            System.out.println(ints[i]);
            i++;
        }
    }
}
