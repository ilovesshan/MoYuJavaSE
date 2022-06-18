package com.ilovesshan.day06;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/18
 * @description:
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        int layer = 10;

        // 初始化二维数组(三角形)
        int[][] triangle = new int[layer][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
        }

        // 将两边全部填充1
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }


        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
