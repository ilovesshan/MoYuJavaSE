package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/5
 * @description:
 */
public class TryExceptionTest {
    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        try {
            int z = y / x;
        } catch (Exception e) {
            System.out.println("x = " + x + "不能做除数~");
        }


        int[] ints = {1, 2, 3, 4};
        try {
            for (int i = 0; i <= ints.length; i++) {
                // 1000行代码 其他的逻辑操作 会改变i的值
                i++;
                System.out.println(ints[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("下标越界了...");
        }

        System.out.println("还有1000行代码继续执行~");
    }
}
