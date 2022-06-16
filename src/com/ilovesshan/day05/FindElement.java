package com.ilovesshan.day05;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class FindElement {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 20, 30, 1, 0, 2, 45, 788, 45, 1, 5};
        int findIndex = -1;

        // 要寻找的元素
        int target = 0;


        for (int i = 0; i < ints.length; i++) {
            if (target == ints[i]) {
                findIndex = i;
                break;
            }
        }
        if (findIndex == -1) {
            System.out.println("啊额、没找到...");
        } else {
            System.out.println("找到了, 索引是: " + findIndex);
        }

    }
}
