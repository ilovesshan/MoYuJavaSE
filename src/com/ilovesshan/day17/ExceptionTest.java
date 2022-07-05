package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/5
 * @description:
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        if (x != 0) {
            int z = y / x;
            System.out.println("z = " + z);
        } else {
            System.out.println("x = " + x + "不能做除数~");
        }

        int[] ints = {1, 2, 3, 4};
        for (int i = 0; i <= ints.length; i++) {
            // 1000行代码 其他的逻辑操作 会改变i的值
            i++;
            if (i >= 0 && i < ints.length) {
                System.out.println(ints[i]);
            } else {
                System.out.println("下标越界了...");
                break;
            }
        }

    }
}
