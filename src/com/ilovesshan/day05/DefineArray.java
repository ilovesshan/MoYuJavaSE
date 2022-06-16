package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class DefineArray {
    /**
     * 这是方法注释
     *
     * @param args args
     */
    public static void main(String[] args) {
        // 定义
        int[] nums1;
        // 声明空间
        nums1 = new int[5];
        // 赋值
        nums1[0] = 0;
        nums1[1] = 2;

        // 1、定义加声明空间
        int[] num2 = new int[5];

        // 2、赋值
        num2[0] = 0;
        num2[1] = 2;


        // 1、定义直接赋值
        int[] num3 = new int[]{0, 1, 2, 3, 4};

    }
}
