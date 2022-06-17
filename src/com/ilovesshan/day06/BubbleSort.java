package com.ilovesshan.day06;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/17
 * @description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {10, 30, 4, 0, -20, 45, 100, 23, 49, -100};

        for (int i = 0; i < nums.length - 1; i++) {
            // 每比较一次之后、就会确定一个最大的数 那么下次进行下一轮比较时、就可以 -i、减少没必要的比较
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 如果前一个比后一个大、那么就交换位置
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
