package com.ilovesshan.day16;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] ints1 = {10, 50, 30, 12, 45, 45, 45, 1};
        int[] ints2 = {10, 50, 30, 12, 45, 45, 45, 10};

        // 比较
        System.out.println(Arrays.equals(ints1, ints2)); // false

        // 排序
        Arrays.sort(ints1);

        // 二分查找
        int searchIndex = Arrays.binarySearch(ints1, 50);
        System.out.println(searchIndex);

        // 格式化打印
        System.out.println(Arrays.toString(ints1)); // false
    }
}
