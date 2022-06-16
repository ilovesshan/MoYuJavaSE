package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class ArrayReverse {
    public static void main(String[] args) {
        int[] ints1 = new int[]{10, 20, 30, 1, 0, 2, 45, 788, 45, 1, 5};
        int[] ints2 = new int[]{10, 20, 30, 1, 0, 2, 45, 788, 45, 1, 5};

        // 方式一
        int[] temp = new int[ints1.length];

        for (int i = 0; i < ints1.length; i++) {
            temp[i] = ints1[ints1.length - 1 - i];
        }
        ints1 = temp;

        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }


        // 方式二

        for (int i = 0; i < ints2.length / 2; i++) {
            int t = ints2[i];
            ints2[i] = ints2[ints2.length - 1 - i];
            ints2[ints2.length - 1 - i] = t;
        }

        for (int i = 0; i < ints2.length; i++) {
            System.out.println(ints2[i]);
        }
    }
}
