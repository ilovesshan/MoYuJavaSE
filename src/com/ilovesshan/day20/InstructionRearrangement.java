package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/17
 * @description: 多线程下 指令重排带来的问题
 */
public class InstructionRearrangement {
    public static int x, y, a, b, count = 0;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();


        while (true) {
            count++;

            // 1、  x = 1,  y = 1,  a = 1, b = 1

            // 2、  x = 1,  y = 1,  a = 0, b = 1

            // 3、  x = 1,  y = 1,  a = 1, b = 0

            // 4、  x = 1,  y = 1,  a = 0, b = 0

            Thread t1 = new Thread(() -> {
                x = 1;
                a = y;
            });

            Thread t2 = new Thread(() -> {
                y = 1;
                b = x;
            });


            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("x = " + x + ", y = " + y + ", a = " + a + ", b = " + b);

            if (a == 0 && b == 0) {
                long endTime = System.currentTimeMillis();
                System.out.println("一共执行了: " + count + "次," + "消耗时间: " + (endTime - startTime));
                break;
            }

            x = 0;
            y = 0;
            a = 0;
            b = 0;
        }
    }

    // 一共执行了: 184593次,消耗时间: 60733
    // 一共执行了: 281061次,消耗时间: 89738


}
