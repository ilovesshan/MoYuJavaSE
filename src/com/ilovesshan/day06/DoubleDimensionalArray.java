package com.ilovesshan.day06;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/18
 * @description:
 */
public class DoubleDimensionalArray {
    public static void main(String[] args) {

        // 初始化 给ints在堆空间中声明3个长度 二层长度没有明确规定、可以动态添加元素
        int[][] ints = new int[3][];

        ints[0] = new int[]{1};
        ints[1] = new int[]{1, 2};
        ints[2] = new int[]{1, 2, 3};


        // 遍历二维数组
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }

        System.out.println("***********************************************");

        int[][] ints1 = new int[2][2];
        ints1[0] = new int[]{1, 2, 3, 4, 5};
        ints1[1] = new int[]{1, 2};


        // 遍历二维数组
        for (int i = 0; i < ints1.length; i++) {
            for (int j = 0; j < ints1[i].length; j++) {
                System.out.print(ints1[i][j]);
            }
            System.out.println();
        }


    }

}
