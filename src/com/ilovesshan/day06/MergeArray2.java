package com.ilovesshan.day06;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/17
 * @description:
 */
public class MergeArray2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 8, 10, 18, 23,};
        int[] nums2 = {3, 5, 6, 7, 8, 18};
        int[] nums3 = new int[nums1.length + nums2.length];


        int i = 0;
        int j = 0;

        while ((i < nums1.length) || (j < nums2.length)) {
            if (i == nums1.length) {
                nums3[i + j] = nums2[j];
                j++;
                continue;
            }

            if (j == nums2.length) {
                nums3[i + j] = nums1[i];
                i++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                nums3[i + j] = nums1[i];
                i++;
            } else {
                nums3[i + j] = nums2[j];
                j++;
            }
        }

        for (int k = 0; k < nums3.length; k++) {
            System.out.println(nums3[k]);
        }

    }
}
