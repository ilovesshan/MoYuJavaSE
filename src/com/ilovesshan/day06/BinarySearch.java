package com.ilovesshan.day06;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/17
 * @description:
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {-100, -30, 0, 3, 10, 23, 56, 89, 120, 520};
        int findIndex = -1;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int middleIndex = (leftIndex + rightIndex) / 2;


        System.out.print("请输入要查找的元素：");
        int targetValue = scanner.nextInt();


        if (targetValue < nums[leftIndex] || targetValue > nums[rightIndex]) {
            System.out.println("查找的元素不在数组中...");
            return;
        }

        if (targetValue == nums[leftIndex]) {
            findIndex = leftIndex;
            System.out.println("找到的索引是:" + findIndex);
            return;
        }
        if (targetValue == nums[rightIndex]) {
            findIndex = rightIndex;
            System.out.println("找到的索引是:" + findIndex);
            return;
        }


        while (leftIndex < rightIndex) {
            if (nums[middleIndex] == targetValue) {
                findIndex = middleIndex;
                System.out.println("找到的索引是:" + findIndex);
                break;
            } else if (targetValue < nums[middleIndex]) {
                rightIndex = --middleIndex;
            } else {
                leftIndex = ++middleIndex;
            }
        }
    }
}
