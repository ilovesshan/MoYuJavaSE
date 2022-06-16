package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class ArrayExchangeElement {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4};
        // 将 ints数组中 2 和 3 交换位置

        int temp = ints[2];
        ints[2] = ints[1];
        ints[1] = temp;

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
