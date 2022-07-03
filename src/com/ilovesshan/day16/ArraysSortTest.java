package com.ilovesshan.day16;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class ArraysSortTest {
    public static void main(String[] args) {
        int count = 10000000;
        int[] arr = new int[count];

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arr[i] = new Random().nextInt();
        }
        Arrays.sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("排序" + count + "条数据耗时：" + (end - start));


        // 排序10000条数据耗时：14
        // 排序1000000条数据耗时：188
        // 排序10000000条数据耗时：1808
        // 排序100000000条数据耗时：17113
    }
}
